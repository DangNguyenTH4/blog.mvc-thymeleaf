package dangnt.thymeleaf.facade.strategy.factory;

import dangnt.thymeleaf.facade.strategy.FacadeApiStrategy;
import dangnt.thymeleaf.facade.strategy.form.SubjectArticleForm;
import dangnt.thymeleaf.facade.strategy.form.TimeArticleForm;
import dangnt.thymeleaf.object.accessdata.SubjectDao;
import dangnt.thymeleaf.object.dto.Article;
import dangnt.thymeleaf.object.dto.HeadDto;
import dangnt.thymeleaf.object.dto.PostDto;
import dangnt.thymeleaf.object.dto.SubjectDto;
import dangnt.thymeleaf.object.exception.WrongTypeException;
import dangnt.thymeleaf.object.mapper.SubjectEntityMapper;
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
class GetArticlesBySubjectId extends FacadeApiStrategy<SubjectArticleForm> {

  @Autowired
  private SubjectEntityMapper subjectMapper;

  @Autowired
  public GetArticlesBySubjectId(PostService postService,
      SubjectService subjectService) {
    super(postService, subjectService);
  }

  @Override
  protected HeadDto getHead(SubjectArticleForm object) {
    HeadDto headDto = new HeadDto();
    headDto.setTitle("Search article by subject!");
    headDto.setMetaContents(null);
    return headDto;
  }

  @Override
  protected Map<String, Object> getBody(SubjectArticleForm object) {
    SubjectDao subjectDao = subjectService
        .getArticleBySubjectId(object.getSubjectId(), object.getPageableAndSortDto());
    SubjectDto subjectDto = subjectMapper.toSubjectDto(subjectDao);

    List<PostDto> postDtos = postService.findPostIntroByIdIn(subjectDao.getSortedPost());
    List<Article> articles = postDtos.stream()
        .map(dto -> Article.builder().id(dto.getId()).post(dto).build())
        .collect(Collectors.toList());
    Map<String, Object> body = new HashMap<>();
    body.put("articles", articles);
    return body;
  }

  @Override
  public void checkCorrectType(Type t) throws WrongTypeException {
    if (!SubjectArticleForm.class.equals(t)) throw new WrongTypeException("Type input must be TimeArticleForm!");
  }
}
