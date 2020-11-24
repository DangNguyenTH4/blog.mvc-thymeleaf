package dangnt.thymeleaf.service;

import dangnt.thymeleaf.object.dto.HeaderDto;

public interface HeaderService {
    HeaderDto findByPostId(Long postId);
}
