package dangnt.thymeleaf.object.dto;

import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PageDto {
    private HeaderDto head;
    private Map<String, Object> body; // Article , Subject, ...
    private Object footer;
}
