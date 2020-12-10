package dangnt.thymeleaf.facade.strategy;

import dangnt.thymeleaf.facade.strategy.factory.FacadeFunctionFactory;
import dangnt.thymeleaf.object.dto.HeadDto;
import dangnt.thymeleaf.object.dto.MenuSubjectDto;
import dangnt.thymeleaf.object.dto.PageDto;
import dangnt.thymeleaf.object.dto.YearlyArticleDto;
import dangnt.thymeleaf.object.dto.responsedto.JsonResponseDto;
import dangnt.thymeleaf.object.exception.WrongTypeException;
import dangnt.thymeleaf.service.PostService;
import dangnt.thymeleaf.service.SubjectService;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public abstract  class FacadeApiStrategy<T> implements FacadeStrategy<T>{

  protected PostService postService;
  protected SubjectService subjectService;

  public FacadeApiStrategy(PostService postService, SubjectService subjectService){
    this.postService = postService;
    this.subjectService = subjectService;
  }

  protected abstract HeadDto getHead(T object);
  protected abstract Map<String, Object> getBody(T object);
  protected abstract void checkCorrectType(Type type) throws WrongTypeException;

  public final PageDto getPage(T object) throws WrongTypeException {
    this.checkCorrectType(object.getClass());
    return PageDto.builder()
        .head(this.getHead(object))
        .topMenu(this.getTopMenu())
        .articleMenu(this.getLeftMenu()) // Build left menu
        .body(this.getBody(object))
        .footer(this.getFoot())
        .build();
  }

  protected final List<MenuSubjectDto> getTopMenu(){
    return subjectService.getSubjectMenu();
  }

  protected final List<YearlyArticleDto> getLeftMenu(){
    return postService.findAllMenuPost();
  }

  protected final Object getFoot(){
    return null;
  }

  @Deprecated
  @Override
  public ResponseEntity<JsonResponseDto> getAjaxBody(T object) {
    JsonResponseDto<Object> result = new JsonResponseDto<>();
    result.setBody(new Object());
    return ResponseEntity.ok(result);
  }
}
