package dangnt.thymeleaf.facade.strategy;

import dangnt.thymeleaf.object.dto.PageDto;
import dangnt.thymeleaf.object.dto.responsedto.JsonResponseDto;
import dangnt.thymeleaf.object.exception.WrongTypeException;
import org.springframework.http.ResponseEntity;

public interface FacadeStrategy<T> {
  PageDto getPage(T object) throws WrongTypeException;
  ResponseEntity<JsonResponseDto> getAjaxBody(T object) throws WrongTypeException;
}
