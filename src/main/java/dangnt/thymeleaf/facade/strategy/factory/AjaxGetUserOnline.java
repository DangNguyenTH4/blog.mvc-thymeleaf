package dangnt.thymeleaf.facade.strategy.factory;

import dangnt.thymeleaf.facade.strategy.FacadeAjaxStrategy;
import dangnt.thymeleaf.object.dto.responsedto.JsonResponseDto;
import dangnt.thymeleaf.object.dto.responsedto.UserOnlineCount;
import dangnt.thymeleaf.object.exception.WrongTypeException;
import dangnt.thymeleaf.service.GlobalResourceService;
import java.lang.reflect.Type;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AjaxGetUserOnline")
public class AjaxGetUserOnline extends FacadeAjaxStrategy {

    @Autowired
    private GlobalResourceService globalResourceService;
    @Override
    protected JsonResponseDto getResponseBody(Object object) {
        try{
            Long count = globalResourceService.countListUserOnline();
            UserOnlineCount userOnlineCount = new UserOnlineCount();
            userOnlineCount.setOnline(count);
            return JsonResponseDto.builder()
                    .time(System.currentTimeMillis())
                    .status(200)
                    .body(userOnlineCount)
                    .message("Done")
                    .build();
        }catch (Exception ex){
            ex.printStackTrace();
            return JsonResponseDto.builder()
                    .time(System.currentTimeMillis())
                    .status(500)
                    .body(null)
                    .message(ex.getMessage())
                    .build();
        }
    }

    @Override
    protected void checkCorrectType(Type type) throws WrongTypeException {

    }


}
