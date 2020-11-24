package dangnt.thymeleaf.service;

import dangnt.thymeleaf.object.dto.MetaContentDto;
import java.util.List;

public interface MetadataService {
    List<MetaContentDto> findByPostId(Long postId);
}
