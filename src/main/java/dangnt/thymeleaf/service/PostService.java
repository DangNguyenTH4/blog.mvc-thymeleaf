package dangnt.thymeleaf.service;

import dangnt.thymeleaf.object.dto.PageableAndSortDto;
import dangnt.thymeleaf.object.dto.PostDto;
import dangnt.thymeleaf.object.dto.YearlyArticleDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface PostService {
    PostDto findPostById(Long postId);
    List<YearlyArticleDto> findAllMenuPost();
    List<PostDto> findAllPost(PageableAndSortDto pageableAndSortDto);
}
