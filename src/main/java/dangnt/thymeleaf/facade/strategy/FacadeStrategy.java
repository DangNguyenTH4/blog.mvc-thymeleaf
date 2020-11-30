package dangnt.thymeleaf.facade.strategy;

import dangnt.thymeleaf.object.dto.PageDto;
import dangnt.thymeleaf.object.exception.WrongTypeException;

public interface FacadeStrategy<T> {
  PageDto getPage(T object) throws WrongTypeException;
}
