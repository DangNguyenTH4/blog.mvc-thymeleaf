package dangnt.thymeleaf.facade;

import dangnt.thymeleaf.object.dto.Article;
import dangnt.thymeleaf.object.dto.PageDto;
import dangnt.thymeleaf.object.dto.SubjectDto;

public interface FacadeApi {
  PageDto getArticle(Long postId);
  PageDto getSubject(String subjectName);
  PageDto search(String typeToSearch, String keyWord);
  PageDto fullTextSearch(String keyWord);
  PageDto getHome();
  PageDto getAnObject();
}
