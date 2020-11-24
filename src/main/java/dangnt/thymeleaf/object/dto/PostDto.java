package dangnt.thymeleaf.object.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
    private String content;
    private String introduction;
    private List<String> tags;
}
