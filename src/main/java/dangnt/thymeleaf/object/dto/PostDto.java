package dangnt.thymeleaf.object.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostDto {
    private String title;
    private String introduction;
    private String content;
    private List<String> tags;
}
