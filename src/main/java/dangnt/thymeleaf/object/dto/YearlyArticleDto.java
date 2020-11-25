package dangnt.thymeleaf.object.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class YearlyArticleDto {
  private Integer year;
  //Sort desc by month
  private List<MonthlyArticleDto> yearlyArticles;
}

