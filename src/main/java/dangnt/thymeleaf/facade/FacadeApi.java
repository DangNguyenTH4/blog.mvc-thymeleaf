package dangnt.thymeleaf.facade;

import dangnt.thymeleaf.object.dto.Article;
import dangnt.thymeleaf.object.dto.SubjectDto;

public interface FacadeApi {
  Article getArticle(Long postId);
  SubjectDto getSubject(String subjectName);
  Object search(String typeToSearch, String keyWord);
  Object fullTextSearch(String keyWord);
  Object getHome();
  Object getAnObject();
}
