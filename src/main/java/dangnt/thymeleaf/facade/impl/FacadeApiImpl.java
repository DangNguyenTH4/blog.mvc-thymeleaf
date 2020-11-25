package dangnt.thymeleaf.facade.impl;

import dangnt.thymeleaf.facade.FacadeApi;
import dangnt.thymeleaf.object.dto.Article;
import dangnt.thymeleaf.object.dto.HeaderDto;
import dangnt.thymeleaf.object.dto.ImageLinkDto;
import dangnt.thymeleaf.object.dto.MetaContentDto;
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
import org.springframework.stereotype.Service;

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
    public Article getArticle(Long postId) {
        PostDto postEntity = postService.findPostById(postId);
        List<MetaContentDto> metadataEntities = metadataService.findByPostId(postId);
        HeaderDto headerEntity = headerService.findByPostId(postId);
        List<ImageLinkDto> imageLinkEntities = imageLinkService.findByPostId(postId);
        Map<String, Object> otherContentProperties = new HashMap<>();
        otherContentProperties.put("articleMenu", postService.findAllMenuPost());
        otherContentProperties.put("key2", "value3");
        otherContentProperties.put("key3", "value3");
        return Article.builder().id(postId).metaContents(metadataEntities)
                .header(headerEntity).post(postEntity).imageLinks(imageLinkEntities)
                .contentProperties(otherContentProperties).build();
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
