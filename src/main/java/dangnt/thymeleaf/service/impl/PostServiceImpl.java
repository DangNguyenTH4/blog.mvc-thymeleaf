package dangnt.thymeleaf.service.impl;

import dangnt.thymeleaf.object.mapper.PostEntityMapper;
import dangnt.thymeleaf.object.dto.Article;
import dangnt.thymeleaf.object.dto.MonthlyArticleDto;
import dangnt.thymeleaf.object.dto.PostDto;
import dangnt.thymeleaf.object.dto.YearlyArticleDto;
import dangnt.thymeleaf.object.model.PostEntity;
import dangnt.thymeleaf.repository.PostRepository;
import dangnt.thymeleaf.service.PostService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.util.DateUtils;

@Service("PostServiceImpl")
@Slf4j
public class PostServiceImpl implements PostService {
  @Autowired
  private PostRepository postRepository;

  @Autowired
  private PostEntityMapper postMapper;

  @Override
  public PostDto findPostById(Long postId) {
    return null;
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
}
