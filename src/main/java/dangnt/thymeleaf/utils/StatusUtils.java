package dangnt.thymeleaf.utils;

import org.springframework.http.HttpStatus;

public final class StatusUtils {
  public static final HttpStatus convert(Integer status){
    switch (status){
      case 200:
        return HttpStatus.OK;
      case 400:
        return HttpStatus.BAD_REQUEST;
      case 401:
        return HttpStatus.UNAUTHORIZED;
      case 403:
        return HttpStatus.FORBIDDEN;
      default:
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
  }
}
