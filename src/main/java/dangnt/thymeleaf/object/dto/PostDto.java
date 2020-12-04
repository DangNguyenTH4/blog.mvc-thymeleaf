package dangnt.thymeleaf.object.dto;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
    private Long id;
    private String title;
    private String introduction;
    private Date created;
    private String createdBy;
    private String content;
    private List<String> tags;
    private String titleImage;
}
