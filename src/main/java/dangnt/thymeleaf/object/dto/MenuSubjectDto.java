package dangnt.thymeleaf.object.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuSubjectDto {
  private Long id;
  private Integer index;
  private String name;
  private Long parentSubject;
  private List<MenuSubjectDto> subSubject;
}
