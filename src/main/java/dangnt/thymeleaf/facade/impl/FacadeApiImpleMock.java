package dangnt.thymeleaf.facade.impl;

import dangnt.thymeleaf.facade.FacadeApi;
import dangnt.thymeleaf.object.dto.Article;
import dangnt.thymeleaf.object.dto.HeadDto;
import dangnt.thymeleaf.object.dto.PageDto;
import dangnt.thymeleaf.object.dto.SubjectDto;
import dangnt.thymeleaf.object.dto.YearlyArticleDto;
import dangnt.thymeleaf.service.PostService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("FacadeApiImpleMock")
@Slf4j
public class FacadeApiImpleMock implements FacadeApi {
    @Autowired
    private PostService postService;
    @Override
//    @Cacheable(value = "articleMenu")
    public PageDto getArticle(Long postId) {
        log.info("Get Articleeeee");
        HeadDto headerDto = new HeadDto();
        headerDto.setTitle("Mock article title!");
        Article article = Article.builder().id(postId)
                .post(null)
                .imageLinks(null)
                .contentProperties(null).build();
        Map<String, Object> body = new HashMap<>();
        body.put("article", article);
        return PageDto.builder()
                .head(null )
                .topMenu(null)
                .articleMenu(postService.findAllMenuPost())
                .body(body)
                .footer(null)
                .build();
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
    public PageDto getHome() {
        return null;
    }

    @Override
    public PageDto getAnObject() {
        return null;
    }
}
