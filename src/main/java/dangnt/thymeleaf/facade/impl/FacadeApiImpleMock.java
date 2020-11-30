package dangnt.thymeleaf.facade.impl;

import dangnt.thymeleaf.facade.FacadeApi;
import dangnt.thymeleaf.facade.strategy.FacadeStrategy;
import dangnt.thymeleaf.facade.strategy.factory.FacadeFunctionFactory;
import dangnt.thymeleaf.facade.strategy.form.SubjectArticleForm;
import dangnt.thymeleaf.facade.strategy.form.TimeArticleForm;
import dangnt.thymeleaf.object.dto.PageDto;
import dangnt.thymeleaf.object.dto.PageableAndSortDto;
import dangnt.thymeleaf.object.exception.WrongTypeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("FacadeApiImpleMock")
@Slf4j
public class FacadeApiImpleMock implements FacadeApi {

    @Autowired
    private FacadeFunctionFactory facadeFunctionFactory;

    @Override
    public PageDto getArticle(Long postId) {
        FacadeStrategy<Long> facadeApiStrategy = facadeFunctionFactory
            .get(FacadeFunctionFactory.GET_ARTICLE_BY_ID);
        try {
            return facadeApiStrategy.getPage(postId);
        } catch (WrongTypeException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PageDto getSubject(String subjectName) {
        return null;
    }

    @Override
    public PageDto search(String typeToSearch, String keyWord) {
        return null;
    }

    @Override
    public PageDto fullTextSearch(String keyWord) {
        return null;
    }

    @Override
    public PageDto getHome(PageableAndSortDto pageableAndSortDto) {
        FacadeStrategy<PageableAndSortDto> facadeApiStrategy = facadeFunctionFactory
            .get(FacadeFunctionFactory.GET_HOME);
        try {
            return facadeApiStrategy.getPage(pageableAndSortDto);
        } catch (WrongTypeException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PageDto getAnObject() {
        return null;
    }

    @Override
    public PageDto getArticleBySubjectId(Long subjectId, PageableAndSortDto pageableAndSortDto) {
        FacadeStrategy<SubjectArticleForm> formFacadeApiStrategy = facadeFunctionFactory
            .get(FacadeFunctionFactory.GET_ARTICLE_BY_SUBJECT_ID);
        try {
            return formFacadeApiStrategy.getPage(new SubjectArticleForm(subjectId, pageableAndSortDto));
        } catch (WrongTypeException e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public PageDto getArticleByTime(Integer year, Integer month,
        PageableAndSortDto pageableAndSortDto) {
        FacadeStrategy<TimeArticleForm> formFacadeApiStrategy = facadeFunctionFactory
            .get(FacadeFunctionFactory.GET_ARTICLE_BY_TIME);
        try {
            return formFacadeApiStrategy.getPage(new TimeArticleForm(year, month, pageableAndSortDto));
        } catch (WrongTypeException e) {
            e.printStackTrace();
        }
        return null;
    }
}
