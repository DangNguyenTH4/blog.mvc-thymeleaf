package dangnt.thymeleaf.facade.impl;

import dangnt.thymeleaf.facade.FacadeApi;
import dangnt.thymeleaf.object.accessdata.SubjectDao;
import dangnt.thymeleaf.object.dto.Article;
import dangnt.thymeleaf.object.dto.HeadDto;
import dangnt.thymeleaf.object.dto.MenuSubjectDto;
import dangnt.thymeleaf.object.dto.MetaContentDto;
import dangnt.thymeleaf.object.dto.PageableAndSortDto;
import dangnt.thymeleaf.object.dto.PageDto;
import dangnt.thymeleaf.object.dto.PostDto;
import dangnt.thymeleaf.object.dto.SubjectDto;
import dangnt.thymeleaf.object.dto.YearlyArticleDto;
import dangnt.thymeleaf.object.mapper.SubjectEntityMapper;
import dangnt.thymeleaf.service.HeaderService;
import dangnt.thymeleaf.service.ImageLinkService;
import dangnt.thymeleaf.service.MetadataService;
import dangnt.thymeleaf.service.PostService;
import dangnt.thymeleaf.service.SubjectService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

//@Service("FacadeApiImpl")
public class FacadeApiImpl implements FacadeApi {
//    @Autowired
    private HeaderService headerService;
//    @Autowired
    private ImageLinkService imageLinkService;
//    @Autowired
    private MetadataService metadataService;
//    @Autowired
    private PostService postService;
//    @Autowired
    private SubjectService subjectService;

//    @Autowired
    private SubjectEntityMapper subjectMapper;

    @Override
    public PageDto getArticle(Long postId) {
        //Build Head
        List<MetaContentDto> metadataEntities = metadataService.findByPostId(postId);
        HeadDto headDto = headerService.findByPostId(postId);
        headDto.setMetaContents(metadataEntities);

        //Build Top Menu
        List<MenuSubjectDto> topMenu = subjectService.getSubjectMenu();

        //Build body
        PostDto postEntity = postService.findPostById(postId);
        Article article = Article.builder().id(postId)
                .post(postEntity)
                .contentProperties(null).build();
        Map<String, Object> body = new HashMap<>();
        body.put("article", article);

        //TODO: build topMenu, build footer...
        return PageDto.builder()
                .head(headDto)
                .topMenu(topMenu)
                .articleMenu(postService.findAllMenuPost()) // Build left menu
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
        List<PostDto> listPostDto = postService.findAllPostIntro(pageableAndSortDto);
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

    @Override
    public PageDto getArticleBySubjectId(Long subjectId, PageableAndSortDto pageableAndSortDto) {
        //Build Head
//        List<MetaContentDto> metadataEntities = metadataService.findByPostId(postId);
        HeadDto headDto = new HeadDto();
        headDto.setTitle("Search article by subject!");
        headDto.setMetaContents(null);
        //Build Top Menu
        List<MenuSubjectDto> topMenu = subjectService.getSubjectMenu();
        //Build left menu
        List<YearlyArticleDto> leftMenu = postService.findAllMenuPost();

        SubjectDao subjectDao = subjectService.getArticleBySubjectId(subjectId, pageableAndSortDto);
        SubjectDto subjectDto = subjectMapper.toSubjectDto(subjectDao);

        List<PostDto> postDtos = postService.findPostIntroByIdIn(subjectDao.getSortedPost());
        List<Article> articles = postDtos.stream()
            .map(dto -> Article.builder().id(dto.getId()).post(dto).build())
            .collect(Collectors.toList());
        Map<String, Object> body = new HashMap<>();
        body.put("articles", articles);
        return PageDto.builder()
            .head(headDto)
            .topMenu(topMenu)
            .articleMenu(leftMenu) // Build left menu
            .body(body)
            .footer(null)
            .build();
    }

    @Override
    public PageDto getArticleByTime(Integer year, Integer month,
        PageableAndSortDto pageableAndSortDto) {
        //Build Head
//        List<MetaContentDto> metadataEntities = metadataService.findByPostId(postId);
        HeadDto headDto = new HeadDto();
        headDto.setTitle("Search article by subject!");
        headDto.setMetaContents(null);
        //Build Top Menu
        List<MenuSubjectDto> topMenu = subjectService.getSubjectMenu();
        //Build left menu
        List<YearlyArticleDto> leftMenu = postService.findAllMenuPost();
        //Build body
        List<PostDto> postDtos = postService.findPostIntroByTime(year, month, pageableAndSortDto);
        Map<String, Object> body = new HashMap<>();
        List<Article> articles = postDtos.stream()
            .map(dto -> Article.builder().id(dto.getId()).post(dto).contentProperties(null).build())
            .collect(Collectors.toList());
        body.put("articles", articles);
        return PageDto.builder()
            .head(headDto)
            .topMenu(topMenu)
            .articleMenu(leftMenu) // Build left menu
            .body(body)
            .footer(null)
            .build();
    }
}
