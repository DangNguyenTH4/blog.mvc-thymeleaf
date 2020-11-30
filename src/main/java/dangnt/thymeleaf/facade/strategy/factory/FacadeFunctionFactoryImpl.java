package dangnt.thymeleaf.facade.strategy.factory;

import dangnt.thymeleaf.facade.strategy.FacadeApiStrategy;
import dangnt.thymeleaf.facade.strategy.FacadeStrategy;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacadeFunctionFactoryImpl implements FacadeFunctionFactory {
    public static final String GET_ARTICLE_BY_ID = "GetArticleById";
    public static final String GET_HOME = "GetHome";
    public static final String GET_ARTICLE_BY_SUBJECT_ID = "GetArticlesBySubjectId";
    public static final String GET_ARTICLE_BY_TIME = "GetArticleByTime";

    public FacadeStrategy get(String function){
        FacadeStrategy facadeStrategy;
        switch (function){
            case GET_ARTICLE_BY_ID: facadeStrategy = getArticleById; break;
            case GET_HOME: facadeStrategy = getHome; break;
            case GET_ARTICLE_BY_SUBJECT_ID: facadeStrategy = getArticlesBySubjectId; break;
            case GET_ARTICLE_BY_TIME : facadeStrategy = getArticleByTime; break;
            default:return null;
        }
        return facadeStrategy;
    }

    //Autowired Facade Function
    @Autowired
    private GetArticleById getArticleById;
    @Autowired
    private GetHome getHome;
    @Autowired
    private GetArticlesBySubjectId getArticlesBySubjectId;
    @Autowired
    private GetArticleByTime getArticleByTime;

}
