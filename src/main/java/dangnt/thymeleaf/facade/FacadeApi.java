package dangnt.thymeleaf.facade;

import dangnt.thymeleaf.dto.Post;
import dangnt.thymeleaf.dto.Subject;

public interface FacadeApi {
  Post getPost();
  Subject getSubject();
  Object search();
  Object getHome();
  Object getAnObject();
}
