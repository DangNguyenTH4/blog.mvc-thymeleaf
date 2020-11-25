package dangnt.thymeleaf.object.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeadDto {
    private String title;
    private List<MetaContentDto> metaContents;
}
