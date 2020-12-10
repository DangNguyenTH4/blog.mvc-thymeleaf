package dangnt.thymeleaf.facade;

import dangnt.thymeleaf.object.dto.PageableAndSortDto;
import dangnt.thymeleaf.object.dto.PageDto;
import dangnt.thymeleaf.object.dto.responsedto.JsonResponseDto;
import dangnt.thymeleaf.sessionmanager.User;
import org.springframework.http.ResponseEntity;

public interface FacadeApi {
  PageDto getArticle(Long postId);
  PageDto getSubject(String subjectName);
  PageDto search(String typeToSearch, String keyWord);
  PageDto fullTextSearch(String keyWord);
  PageDto getHome(PageableAndSortDto pagableAndSortDto);
  PageDto getAnObject();
  PageDto getArticleBySubjectId(Long subjectId, PageableAndSortDto pageableAndSortDto);
  PageDto getArticleByTime(Integer year, Integer month, PageableAndSortDto pageableAndSortDto);
  ResponseEntity<JsonResponseDto> countUserOnline();
  void addNewUserOnline(User user);
}
