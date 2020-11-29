package dangnt.thymeleaf.object.dto;

import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDto {
  private List<MetaContentDto> metaContents;

  private String name;
  private Long id;
  private List<Article> sortedPost;
  private List<Article> tentPostHottest;

  private Map<String, String> contentProperties;
}
