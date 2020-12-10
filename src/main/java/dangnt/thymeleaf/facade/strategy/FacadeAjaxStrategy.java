package dangnt.thymeleaf.facade.strategy;

import dangnt.thymeleaf.object.dto.PageDto;
import dangnt.thymeleaf.object.dto.responsedto.JsonResponseDto;
import dangnt.thymeleaf.object.exception.WrongTypeException;
import dangnt.thymeleaf.utils.StatusUtils;
import java.lang.reflect.Type;
import java.util.Map;
import org.springframework.http.ResponseEntity;

public abstract class FacadeAjaxStrategy<T> implements FacadeStrategy<T> {

    //should not be here. Should be somewhere
    protected abstract void checkCorrectType(Type type) throws WrongTypeException;

    protected Map<String, Object> getBody(T object) {
        return null;
    }

    protected JsonResponseDto getResponseBody(T object) {
        return JsonResponseDto.builder().
                time(System.currentTimeMillis())
                .body(null)
                .status(505)
                .message("Method not implement yet!").build();
    }

    //Not use
    @Deprecated
    @Override
    public PageDto getPage(T object) throws WrongTypeException {
        this.checkCorrectType(object.getClass());
        return PageDto.builder()
                .head(null)
                .topMenu(null)
                .articleMenu(null)
                .body(this.getBody(object))
                .footer(null)
                .build();
    }

    @Override
    public ResponseEntity<JsonResponseDto> getAjaxBody(T object) throws WrongTypeException {
        this.checkCorrectType(object == null ? null : object.getClass());
        JsonResponseDto responseBody = this.getResponseBody(object);
        return new ResponseEntity<>(responseBody, StatusUtils.convert(responseBody.getStatus()));
    }
}
