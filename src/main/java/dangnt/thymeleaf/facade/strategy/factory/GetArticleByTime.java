package dangnt.thymeleaf.facade.strategy.factory;

import dangnt.thymeleaf.facade.strategy.FacadeApiStrategy;
import dangnt.thymeleaf.facade.strategy.form.TimeArticleForm;
import dangnt.thymeleaf.object.dto.Article;
import dangnt.thymeleaf.object.dto.HeadDto;
import dangnt.thymeleaf.object.dto.PostDto;
import dangnt.thymeleaf.object.exception.WrongTypeException;
import dangnt.thymeleaf.service.PostService;
import dangnt.thymeleaf.service.SubjectService;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class GetArticleByTime extends FacadeApiStrategy<TimeArticleForm> {

  @Autowired
  public GetArticleByTime(PostService postService,
      SubjectService subjectService) {
    super(postService, subjectService);
  }

  @Override
  protected HeadDto getHead(TimeArticleForm object) {
    HeadDto headDto = new HeadDto();
    headDto.setTitle("Search article by time!");
    headDto.setMetaContents(null);
    return headDto;
  }

  @Override
  protected Map<String, Object> getBody(TimeArticleForm object) {
    List<PostDto> postDtos = postService
        .findPostIntroByTime(object.getYear(), object.getMonth(), object.getPageableAndSortDto());
    Map<String, Object> body = new HashMap<>();
    List<Article> articles = postDtos.stream()
        .map(dto -> Article.builder().id(dto.getId()).post(dto).contentProperties(null).build())
        .collect(Collectors.toList());
    body.put("articles", articles);
    return body;
  }

  @Override
  public void checkCorrectType(Type t) throws WrongTypeException {
    if (!TimeArticleForm.class.equals(t)) throw new WrongTypeException("Type input must be TimeArticleForm!");
  }
}
