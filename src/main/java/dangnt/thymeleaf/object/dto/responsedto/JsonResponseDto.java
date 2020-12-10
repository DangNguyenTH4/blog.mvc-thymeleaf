package dangnt.thymeleaf.object.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JsonResponseDto<R> {
  private Long time;
  private R body;
  private String message;
  private Integer status;
}
