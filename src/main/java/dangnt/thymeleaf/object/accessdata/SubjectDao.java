package dangnt.thymeleaf.object.accessdata;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDao {
  private Long id;
  private String name;
  private List<Long> sortedPost;
  private List<Long> tenHotPost;
}
