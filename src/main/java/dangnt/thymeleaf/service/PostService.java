package dangnt.thymeleaf.service;

import dangnt.thymeleaf.object.dto.PostDto;
import dangnt.thymeleaf.object.dto.YearlyArticleDto;
import java.util.List;

public interface PostService {
    PostDto findPostById(Long postId);
    List<YearlyArticleDto> findAllMenuPost();
}
