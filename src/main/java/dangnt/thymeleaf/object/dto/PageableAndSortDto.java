package dangnt.thymeleaf.object.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageableAndSortDto {
  private int pageIndex;
  private int pageSize;
  private String sortBy;
}
