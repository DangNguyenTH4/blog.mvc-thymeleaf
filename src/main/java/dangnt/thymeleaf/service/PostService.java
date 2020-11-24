package dangnt.thymeleaf.service;

import dangnt.thymeleaf.object.dto.PostDto;

public interface PostService {
    PostDto findPostById(Long postId);

}
