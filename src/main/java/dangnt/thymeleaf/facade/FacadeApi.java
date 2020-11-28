package dangnt.thymeleaf.facade;

import dangnt.thymeleaf.object.dto.PageableAndSortDto;
import dangnt.thymeleaf.object.dto.PageDto;

public interface FacadeApi {
  PageDto getArticle(Long postId);
  PageDto getSubject(String subjectName);
  PageDto search(String typeToSearch, String keyWord);
  PageDto fullTextSearch(String keyWord);
  PageDto getHome(PageableAndSortDto pagableAndSortDto);
  PageDto getAnObject();
}
