package dangnt.thymeleaf.facade.impl;

import dangnt.thymeleaf.facade.FacadeApi;
import dangnt.thymeleaf.object.dto.Article;
import dangnt.thymeleaf.object.dto.HeaderDto;
import dangnt.thymeleaf.object.dto.MonthlyArticleDto;
import dangnt.thymeleaf.object.dto.PostDto;
import dangnt.thymeleaf.object.dto.SubjectDto;
import dangnt.thymeleaf.object.dto.YearlyArticleDto;
import dangnt.thymeleaf.service.PostService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("FacadeApiImpleMock")
@Slf4j
public class FacadeApiImpleMock implements FacadeApi {
    @Autowired
    private PostService postService;
    @Override
//    @Cacheable(value = "articleMenu")
    public Article getArticle(Long postId) {
        log.info("Get Articleeeee");
        HeaderDto headerDto = new HeaderDto();
        headerDto.setTitle("Mock article title!");
        Map<String, Object> content = new HashMap<>();
        content.put("key1","hả");
        List<YearlyArticleDto> yearlyArticleDtoList = postService.findAllMenuPost();

        content.put("articleMenu", yearlyArticleDtoList);
        return Article.builder().header(headerDto).contentProperties(content).build();
    }

    @Override
    public SubjectDto getSubject(String subjectName) {
        return null;
    }

    @Override
    public Object search(String typeToSearch, String keyWord) {
        return null;
    }

    @Override
    public Object fullTextSearch(String keyWord) {
        return null;
    }

    @Override
    public Object getHome() {
        return null;
    }

    @Override
    public Object getAnObject() {
        return null;
    }
}
