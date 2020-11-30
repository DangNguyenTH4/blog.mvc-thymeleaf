package dangnt.thymeleaf.facade.strategy.form;

import dangnt.thymeleaf.object.dto.PageableAndSortDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectArticleForm {
  public SubjectArticleForm(Long subjectId, PageableAndSortDto pageableAndSortDto){
    this.subjectId = subjectId;
    this.pageableAndSortDto = pageableAndSortDto;
  }
  private Long subjectId;
  private PageableAndSortDto pageableAndSortDto;
}
