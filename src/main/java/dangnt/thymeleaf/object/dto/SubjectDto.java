package dangnt.thymeleaf.object.dto;

import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDto {
  private List<MetaContentDto> metaContents;

  private String subjectName;
  private String subjectId;
  private List<Article> tenPostRecent;
  private List<Article> tentPostHottest;

  private Map<String, String> contentProperties;
}
