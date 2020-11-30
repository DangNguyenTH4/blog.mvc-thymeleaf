package dangnt.thymeleaf.facade.strategy.factory;

import dangnt.thymeleaf.facade.strategy.FacadeAjaxStrategy;
import dangnt.thymeleaf.facade.strategy.FacadeStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FacadeFunctionFactoryImpl implements FacadeFunctionFactory {
    public static final String GETARTICLEBYID = "GetArticleById";
    public static final String GETHOME = "GetHome";
    public static final String GET_ARTICLE_BY_SUBJECT_ID = "GetArticlesBySubjectId";
    public static final String GET_ARTICLE_BY_TIME = "GetArticleByTime";

    public FacadeStrategy get(String function){
        switch (function){
            case GETARTICLEBYID: return getArticleById;
            case GETHOME : return getHome;
            case GET_ARTICLE_BY_SUBJECT_ID: return getArticlesBySubjectId;
            case GET_ARTICLE_BY_TIME : return getArticleByTime;
            default:return null;
        }

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
