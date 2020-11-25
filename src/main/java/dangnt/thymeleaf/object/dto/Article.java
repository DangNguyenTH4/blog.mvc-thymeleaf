package dangnt.thymeleaf.object.dto;

import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Article {
  private Long id;
  private PostDto post;
  private List<MetaContentDto> metaContents;
  private List<ImageLinkDto> imageLinks;
  private HeaderDto header;
  private Map<String, Object> contentProperties;
}
