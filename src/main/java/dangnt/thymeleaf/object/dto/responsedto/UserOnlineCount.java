package dangnt.thymeleaf.object.dto.responsedto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
public class UserOnlineCount {
    private Long online;
    private Long onlineMobile;
    private Long onlineDesktop;
}
