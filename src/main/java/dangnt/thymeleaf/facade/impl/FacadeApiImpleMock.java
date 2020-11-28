package dangnt.thymeleaf.facade.impl;

import dangnt.thymeleaf.facade.FacadeApi;
import dangnt.thymeleaf.object.dto.Article;
import dangnt.thymeleaf.object.dto.HeadDto;
import dangnt.thymeleaf.object.dto.MenuSubjectDto;
import dangnt.thymeleaf.object.dto.PageableAndSortDto;
import dangnt.thymeleaf.object.dto.PageDto;
import dangnt.thymeleaf.object.dto.PostDto;
import dangnt.thymeleaf.service.PostService;
import dangnt.thymeleaf.service.SubjectService;
import dangnt.thymeleaf.templateutils.TemplateService;
import java.util.ArrayList;
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
    public PageDto getHome(PageableAndSortDto pageableAndSortDto) {
        //Build Head
//        List<MetaContentDto> metadataEntities = metadataService.findByPostId(postId);
        HeadDto headDto = new HeadDto();
        headDto.setTitle("Welcome to Dang's Blog!");
        headDto.setMetaContents(null);
        //Build Top Menu
        List<MenuSubjectDto> topMenu = subjectService.getSubjectMenu();

        //Build body
        List<Article> articlesIntroduction = new ArrayList<>();
        List<PostDto> listPostDto = postService.findAllPost(pageableAndSortDto);
        Article article;
        for(PostDto dto : listPostDto){
            article = Article.builder()
                .id(dto.getId())
                .post(dto)
                .contentProperties(null).build();
            articlesIntroduction.add(article);
        }
        Map<String, Object> body = new HashMap<>();
        body.put("articles", articlesIntroduction);
        body.put("nextPage", pageableAndSortDto.getPageIndex()+1);
        return PageDto.builder()
            .head(headDto)
            .topMenu(topMenu)
            .articleMenu(postService.findAllMenuPost()) // Build left menu
            .body(body)
            .footer(null)
            .build();
    }

    @Override
    public PageDto getAnObject() {
        return null;
    }
}
