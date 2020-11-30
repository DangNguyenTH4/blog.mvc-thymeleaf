package dangnt.thymeleaf.facade.strategy.factory;

import dangnt.thymeleaf.facade.strategy.FacadeApiStrategy;
import dangnt.thymeleaf.object.dto.Article;
import dangnt.thymeleaf.object.dto.HeadDto;
import dangnt.thymeleaf.object.dto.PostDto;
import dangnt.thymeleaf.object.exception.WrongTypeException;
import dangnt.thymeleaf.service.PostService;
import dangnt.thymeleaf.service.SubjectService;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class GetArticleById extends FacadeApiStrategy<Long> {
//
//  @Autowired
//  private MetadataService metadataService;
//
//  @Autowired
//  private HeaderService headerService;

  @Autowired
  public GetArticleById(PostService postService,
      SubjectService subjectService) {
    super(postService, subjectService);
  }

  @Override
  protected HeadDto getHead(Long postId) {
    //Build Head
//    List<MetaContentDto> metadataEntities = metadataService.findByPostId(postId);
//    HeadDto headDto = headerService.findByPostId(postId);
//    headDto.setMetaContents(metadataEntities);
    //TODO MOCK
    HeadDto headDto = new HeadDto();
    headDto.setTitle("Mock article title!");
    return headDto;
  }

  @Override
  protected Map<String, Object> getBody(Long postId) {
    PostDto postEntity = postService.findPostById(postId);
    Article article = Article.builder().id(postId)
        .post(postEntity)
        .contentProperties(null).build();
    Map<String, Object> body = new HashMap<>();
    body.put("article", article);
    return body;
  }

  @Override
  public void checkCorrectType(Type t) throws WrongTypeException {
    if (!Long.class.equals(t)) throw new WrongTypeException("Type input must be Long!");
  }
}
