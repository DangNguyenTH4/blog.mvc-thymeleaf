package dangnt.thymeleaf.service.impl;

import dangnt.thymeleaf.object.dto.PageableAndSortDto;
import dangnt.thymeleaf.object.mapper.PostEntityMapper;
import dangnt.thymeleaf.object.dto.Article;
import dangnt.thymeleaf.object.dto.MonthlyArticleDto;
import dangnt.thymeleaf.object.dto.PostDto;
import dangnt.thymeleaf.object.dto.YearlyArticleDto;
import dangnt.thymeleaf.object.model.ImageLinkEntity;
import dangnt.thymeleaf.object.model.PostEntity;
import dangnt.thymeleaf.repository.ImageLinkRepository;
import dangnt.thymeleaf.repository.PostRepository;
import dangnt.thymeleaf.service.PostService;
import dangnt.thymeleaf.templateutils.TemplateService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.swing.text.html.Option;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.util.DateUtils;

@Service("PostServiceImpl")
@Slf4j
public class PostServiceImpl implements PostService {
  @Autowired
  private PostRepository postRepository;

  @Autowired
  private ImageLinkRepository imageLinkRepository;

  @Autowired
  private PostEntityMapper postMapper;

  @Autowired
  private TemplateService templateService;


  @Override
  public PostDto findPostById(Long postId) {
    Optional<PostEntity> entityOptional = postRepository.findById(postId);
    PostDto postDto = null;

    if(entityOptional.isPresent()){
      postDto = postMapper.toPostDto(entityOptional.get());
      //Fill imageLink into content!
      List<ImageLinkEntity> imageLinks = imageLinkRepository.findByPostId(postId);
      Map<String, ImageLinkEntity> mapImageLinks = imageLinks.stream()
          .collect(Collectors.toMap(ImageLinkEntity::getName, Function.identity()));
      Context context = new Context();
      context.setVariable("imageLinks", mapImageLinks);
      postDto.setContent(templateService.merge(postDto.getContent(), context));
    }
    return postDto;

  }

  @Override
  @Cacheable(value = "articleMenu")
  public List<YearlyArticleDto> findAllMenuPost() {
    List<YearlyArticleDto> yearlyArticleDtos = new ArrayList<>();
    //map monthly article. Decsending sort.
    Map<Integer, Map<Integer, MonthlyArticleDto>> yearlyArticleDtoMap = new TreeMap<>(Collections.reverseOrder());
    List<PostEntity> list = postRepository.findAllOrderById();
    for(PostEntity postEntity : list){
      Date created = postEntity.getCreated();
      if(created == null){
        continue;
      }
      int year = DateUtils.year(created);
      int month = DateUtils.month(created);
      //add to map year not exist
      yearlyArticleDtoMap.putIfAbsent(year, new TreeMap<>());
      Map<Integer, MonthlyArticleDto> monthlyMap = yearlyArticleDtoMap.get(year);
      //add to map year not exist
      monthlyMap.putIfAbsent(month, new MonthlyArticleDto(String.valueOf(month), new ArrayList<>()));
      Article article = Article.builder()
              .id(postEntity.getId())
              .post(postMapper.toPostDto(postEntity))
              .build();
      monthlyMap.get(month).getMonthlyArticles().add(article);
    }
    if(CollectionUtils.isEmpty(yearlyArticleDtoMap)){
      return yearlyArticleDtos;
    }
    YearlyArticleDto yearlyArticleDto;
    for(Entry<Integer, Map<Integer, MonthlyArticleDto>> entry : yearlyArticleDtoMap.entrySet()){
        yearlyArticleDto = new YearlyArticleDto();
        yearlyArticleDto.setYear(entry.getKey());
        yearlyArticleDto.setYearlyArticles(new ArrayList<>(entry.getValue().values()));
        yearlyArticleDtos.add(yearlyArticleDto);
    }
    return yearlyArticleDtos;
  }

  @Override
  public List<PostDto> findAllPost(PageableAndSortDto pageableAndSortDto) {
    Pageable pageable = PageRequest
        .of(pageableAndSortDto.getPageIndex(), pageableAndSortDto.getPageSize(),
            Sort.by("created").descending());
    Page<PostEntity> page = postRepository.findAll(pageable);
    List<PostEntity> listPostEntityList = page.getContent();
    PostDto dto;
    List<PostDto> result = new ArrayList<>();
    for(PostEntity postEntity : listPostEntityList){
       dto = postMapper.toIntroductionPostDto(postEntity);
       result.add(dto);
    }
    return result;
  }
}
