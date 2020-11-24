package dangnt.thymeleaf.service;

import dangnt.thymeleaf.object.dto.ImageLinkDto;
import java.util.List;

public interface ImageLinkService {
    List<ImageLinkDto> findByPostId(Long postId);
}
