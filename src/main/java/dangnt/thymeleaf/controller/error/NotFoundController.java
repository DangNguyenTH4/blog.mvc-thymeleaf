package dangnt.thymeleaf.controller.error;

import dangnt.thymeleaf.object.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class NotFoundController {
 @ExceptionHandler(value = NotFoundException.class)
  public ResponseEntity<String> notFound(NotFoundException no){
   return new ResponseEntity<String>( "<div style=\"width:100%; height:100%; background-color:red; background-image:url(https://i2.wp.com/learn.onemonth.com/wp-content/uploads/2017/08/1-10.png)\"><h1 style=\"text-align:center\">Not found</h1></div>", HttpStatus.NOT_FOUND);
 }
}
