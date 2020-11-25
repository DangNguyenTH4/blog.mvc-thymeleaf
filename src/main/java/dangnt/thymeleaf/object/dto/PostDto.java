package dangnt.thymeleaf.object.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
    private Long id;
    private String title;
    private String introduction;
    private String content;
    private String tags;
}
