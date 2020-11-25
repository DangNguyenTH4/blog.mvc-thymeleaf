package dangnt.thymeleaf.facade.impl;

import dangnt.thymeleaf.facade.FacadeApi;
import dangnt.thymeleaf.object.dto.Article;
import dangnt.thymeleaf.object.dto.HeadDto;
import dangnt.thymeleaf.object.dto.ImageLinkDto;
import dangnt.thymeleaf.object.dto.MetaContentDto;
import dangnt.thymeleaf.object.dto.PageDto;
import dangnt.thymeleaf.object.dto.PostDto;
import dangnt.thymeleaf.object.dto.SubjectDto;
import dangnt.thymeleaf.service.HeaderService;
import dangnt.thymeleaf.service.ImageLinkService;
import dangnt.thymeleaf.service.MetadataService;
import dangnt.thymeleaf.service.PostService;
import dangnt.thymeleaf.service.SubjectService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public PageDto getArticle(Long postId) {
        PostDto postEntity = postService.findPostById(postId);
        List<MetaContentDto> metadataEntities = metadataService.findByPostId(postId);
        HeadDto headDto = headerService.findByPostId(postId);
        headDto.setMetaContents(metadataEntities);

        List<ImageLinkDto> imageLinkEntities = imageLinkService.findByPostId(postId);
        Article article = Article.builder().id(postId)
                .post(postEntity)
                .imageLinks(imageLinkEntities)
                .contentProperties(null).build();
        Map<String, Object> body = new HashMap<>();
        body.put("article", article);
        return PageDto.builder()
                .head(headDto )
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
