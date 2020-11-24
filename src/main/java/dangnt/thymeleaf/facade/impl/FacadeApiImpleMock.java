package dangnt.thymeleaf.facade.impl;

import dangnt.thymeleaf.facade.FacadeApi;
import dangnt.thymeleaf.object.dto.Article;
import dangnt.thymeleaf.object.dto.HeaderDto;
import dangnt.thymeleaf.object.dto.SubjectDto;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service("FacadeApiImpleMock")
public class FacadeApiImpleMock implements FacadeApi {
    @Override
    public Article getArticle(Long postId) {
        HeaderDto headerDto = new HeaderDto();
        headerDto.setTitle("Mock article title!");
        Map<String, String> content = new HashMap<>();
        content.put("key1","hả");
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
