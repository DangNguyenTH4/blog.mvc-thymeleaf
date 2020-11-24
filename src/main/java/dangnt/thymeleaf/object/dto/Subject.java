package dangnt.thymeleaf.object.dto;

import java.util.List;

public class Subject {
  private MetaContent metaContent;

  private String subjectName;
  private String subjectId;
  private List<Post> tenPostRecent;
  private List<Post> tentPostHottest;
}
