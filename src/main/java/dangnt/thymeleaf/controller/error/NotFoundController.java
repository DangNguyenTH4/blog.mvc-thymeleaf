package dangnt.thymeleaf.controller.error;

import dangnt.thymeleaf.object.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class NotFoundController {
 @ExceptionHandler(value = NotFoundException.class)
  public ResponseEntity<String> notFound(NotFoundException no){
   return new ResponseEntity<String>( "Not found", HttpStatus.NOT_FOUND);
 }
}
