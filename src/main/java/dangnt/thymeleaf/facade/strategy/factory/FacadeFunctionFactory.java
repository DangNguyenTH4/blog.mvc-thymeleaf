package dangnt.thymeleaf.facade.strategy.factory;

import dangnt.thymeleaf.facade.strategy.FacadeStrategy;

public interface FacadeFunctionFactory {
  String GET_ARTICLE_BY_ID = "GetArticleById";
  String GET_HOME = "GetHome";
  String GET_ARTICLE_BY_SUBJECT_ID = "GetArticlesBySubjectId";
  String GET_ARTICLE_BY_TIME = "GetArticleByTime";
  //AJAX
  String GET_USER_ONLINE = "AjaxGetUserOnline";

  FacadeStrategy get(String functionName);
}
