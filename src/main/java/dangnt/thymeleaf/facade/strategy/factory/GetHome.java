package dangnt.thymeleaf.facade.strategy.factory;

import dangnt.thymeleaf.facade.strategy.FacadeApiStrategy;
import dangnt.thymeleaf.object.dto.Article;
import dangnt.thymeleaf.object.dto.HeadDto;
import dangnt.thymeleaf.object.dto.PageableAndSortDto;
import dangnt.thymeleaf.object.dto.PostDto;
import dangnt.thymeleaf.service.PostService;
import dangnt.thymeleaf.service.SubjectService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class GetHome extends FacadeApiStrategy<PageableAndSortDto> {
  @Autowired
  public GetHome(PostService postService,
      SubjectService subjectService) {
    super(postService, subjectService);
  }

  @Override
  protected HeadDto getHead(PageableAndSortDto object) {
    HeadDto headDto = new HeadDto();
    headDto.setTitle("Welcome to Dang's Blog!");
    headDto.setMetaContents(null);
    return headDto;
  }

  @Override
  protected Map<String, Object> getBody(PageableAndSortDto pageableAndSortDto) {
    List<Article> articlesIntroduction = new ArrayList<>();
    List<PostDto> listPostDto = postService.findAllPostIntro(pageableAndSortDto);
    Article article;
    for(PostDto dto : listPostDto){
      article = Article.builder()
          .id(dto.getId())
          .post(dto)
          .contentProperties(null).build();
      articlesIntroduction.add(article);
    }
    Map<String, Object> body = new HashMap<>();
    body.put("articles", articlesIntroduction);
    body.put("nextPage", pageableAndSortDto.getPageIndex()+1);
    return body;
  }
}
