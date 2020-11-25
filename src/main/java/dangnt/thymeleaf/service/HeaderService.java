package dangnt.thymeleaf.service;

import dangnt.thymeleaf.object.dto.HeadDto;

public interface HeaderService {
    HeadDto findByPostId(Long postId);
}
