package dangnt.thymeleaf.service.impl;

import dangnt.thymeleaf.object.accessdata.SubjectDao;
import dangnt.thymeleaf.object.dto.MenuSubjectDto;
import dangnt.thymeleaf.object.dto.PageableAndSortDto;
import dangnt.thymeleaf.object.dto.PostDto;
import dangnt.thymeleaf.object.dto.SubjectDto;
import dangnt.thymeleaf.object.exception.NotFoundException;
import dangnt.thymeleaf.object.mapper.SubjectEntityMapper;
import dangnt.thymeleaf.object.model.BaseEntity;
import dangnt.thymeleaf.object.model.SubjectEntity;
import dangnt.thymeleaf.object.model.SubjectPostEntity;
import dangnt.thymeleaf.repository.SubjectRepository;
import dangnt.thymeleaf.service.SubjectService;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service("SubjectServiceImpl")
@Slf4j
public class SubjectServiceImpl implements SubjectService {

  @Autowired
  private SubjectRepository subjectRepository;

  @Autowired
  private SubjectEntityMapper subjectEntityMapper;

  @Cacheable("topMenu")
  @Override
  public List<MenuSubjectDto> getSubjectMenu() {

    List<SubjectEntity> subjectEntities = subjectRepository.findAllSortedByIndex();
    Map<Long, MenuSubjectDto> temp = subjectEntities.stream().map(subjectEntityMapper::toMenuSubject
//        entity -> {
//          MenuSubjectDto dto = subjectEntityMapper.toMenuSubject(entity);
//          dto.setSubSubject(new ArrayList<>());
//          return dto;
//        }
    ).collect(Collectors.toMap(MenuSubjectDto::getId, Function.identity()));

    //Subject have subSubject -> it fine
    for(Entry<Long, MenuSubjectDto> entry : temp.entrySet()){
      MenuSubjectDto subjectDto = entry.getValue();
      if(subjectDto.getParentSubject() != null){
        List<MenuSubjectDto> listSub = temp.get(subjectDto.getParentSubject()).getSubSubject();
        if(CollectionUtils.isEmpty(listSub)){
          listSub = new ArrayList<>();
          temp.get(subjectDto.getParentSubject()).setSubSubject(listSub);
        }
        listSub.add(subjectDto);
      }
    }
    return temp.values().stream().filter(subject -> subject.getParentSubject() == null).collect(
        Collectors.toList());
  }

  @Override
  public SubjectDao getArticleBySubjectId(Long subjectId,
      PageableAndSortDto pageableAndSortDto) throws NotFoundException {
    Optional<SubjectEntity> entityOptional = subjectRepository.findById(subjectId);
    if(entityOptional.isPresent()){
      //Get metadata

      //Get sortedPost
      SubjectEntity entity = entityOptional.get();
      List<SubjectPostEntity> sortedPost =
          entity.getSubjectPost() != null ? entity.getSubjectPost().stream()
              .sorted((sp1, sp2)-> sp2.getCreated().compareTo(sp1.getCreated())) // Reserved sort
              .skip(pageableAndSortDto.getPageIndex() * pageableAndSortDto.getPageSize())
              .limit(pageableAndSortDto.getPageSize()).collect(Collectors.toList()) : new ArrayList<>();
      SubjectDao subjectDao = subjectEntityMapper.toSubjectDao(entity);
      subjectDao.setSortedPost(
          sortedPost.stream().map(sp -> sp.getId().getPostId()).collect(Collectors.toList()));
      return subjectDao;
    }else{
      throw new NotFoundException();
    }
  }
}
