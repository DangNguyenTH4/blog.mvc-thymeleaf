package dangnt.thymeleaf.facade.impl;

import dangnt.thymeleaf.facade.FacadeApi;
import dangnt.thymeleaf.object.dto.Article;
import dangnt.thymeleaf.object.dto.HeadDto;
import dangnt.thymeleaf.object.dto.ImageLinkDto;
import dangnt.thymeleaf.object.dto.MenuSubjectDto;
import dangnt.thymeleaf.object.dto.PageDto;
import dangnt.thymeleaf.object.dto.PostDto;
import dangnt.thymeleaf.object.dto.SubjectDto;
import dangnt.thymeleaf.object.dto.YearlyArticleDto;
import dangnt.thymeleaf.service.PostService;
import dangnt.thymeleaf.service.SubjectService;
import dangnt.thymeleaf.templateutils.TemplateService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.context.Context;

@Service("FacadeApiImpleMock")
@Slf4j
public class FacadeApiImpleMock implements FacadeApi {
    @Autowired
    private PostService postService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private TemplateService templateService;
    @Override
//    @Cacheable(value = "articleMenu")
    public PageDto getArticle(Long postId) {
        log.info("Get Articleeeee");
        HeadDto headerDto = new HeadDto();
        headerDto.setTitle("Mock article title!");

        //Build top menu
        List<MenuSubjectDto> topMenu = subjectService.getSubjectMenu();

        PostDto post =  postService.findPostById(postId);

         Article article = Article.builder().id(postId)
                .post(post)
                .contentProperties(null).build();
        Map<String, Object> body = new HashMap<>();
        body.put("article", article);
        return PageDto.builder()
                .head(null )
                .topMenu(topMenu)
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
