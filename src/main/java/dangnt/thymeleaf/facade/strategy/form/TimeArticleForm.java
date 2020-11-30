package dangnt.thymeleaf.facade.strategy.form;

import dangnt.thymeleaf.object.dto.PageableAndSortDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeArticleForm {
  public TimeArticleForm(Integer year, Integer month, PageableAndSortDto pageableAndSortDto){
    this.year = year;
    this.month = month;
    this.pageableAndSortDto = pageableAndSortDto;
  }
  private Integer year;
  private Integer month;
  private PageableAndSortDto pageableAndSortDto;
}
