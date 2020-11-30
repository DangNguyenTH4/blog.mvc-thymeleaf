package dangnt.thymeleaf.facade.strategy;

import dangnt.thymeleaf.object.dto.PageDto;

public interface FacadeStrategy<T> {
  PageDto getPage(T object);
}
