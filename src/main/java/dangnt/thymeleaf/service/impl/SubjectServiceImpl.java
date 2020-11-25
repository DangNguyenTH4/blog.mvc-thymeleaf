package dangnt.thymeleaf.service.impl;

import dangnt.thymeleaf.object.dto.MenuSubjectDto;
import dangnt.thymeleaf.object.mapper.SubjectEntityMapper;
import dangnt.thymeleaf.object.model.SubjectEntity;
import dangnt.thymeleaf.repository.SubjectRepository;
import dangnt.thymeleaf.service.SubjectService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
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
}
