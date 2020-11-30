package dangnt.thymeleaf.facade.strategy.factory;

import dangnt.thymeleaf.facade.strategy.FacadeStrategy;

public interface FacadeFunctionFactory {
  FacadeStrategy get(String functionName);
}
