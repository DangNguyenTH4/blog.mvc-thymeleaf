package dangnt.thymeleaf.facade.strategy;

import dangnt.thymeleaf.object.dto.HeadDto;
import dangnt.thymeleaf.object.dto.MenuSubjectDto;
import dangnt.thymeleaf.object.dto.PageDto;
import dangnt.thymeleaf.object.dto.YearlyArticleDto;
import dangnt.thymeleaf.service.PostService;
import dangnt.thymeleaf.service.SubjectService;
import java.util.List;
import java.util.Map;

public abstract  class FacadeApiStrategy<T> {

  private PostService postService;
  private SubjectService subjectService;

  public abstract HeadDto getHead(T object);
  public abstract Map<String, Object> getBody(T object);

  public final PageDto getPage(T object){
    return PageDto.builder()
        .head(this.getHead(object))
        .topMenu(this.getTopMenu())
        .articleMenu(this.getLeftMenu()) // Build left menu
        .body(this.getBody(object))
        .footer(this.getFoot())
        .build();
  }
  public final List<MenuSubjectDto> getTopMenu(){
    return subjectService.getSubjectMenu();
  }

  public final List<YearlyArticleDto> getLeftMenu(){
    return postService.findAllMenuPost();
  }

  public final Object getFoot(){
    return null;
  }
}
