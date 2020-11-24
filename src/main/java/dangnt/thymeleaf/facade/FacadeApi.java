package dangnt.thymeleaf.facade;

import dangnt.thymeleaf.object.dto.Post;
import dangnt.thymeleaf.object.dto.Subject;

public interface FacadeApi {
  Post getPost();
  Subject getSubject();
  Object search();
  Object getHome();
  Object getAnObject();
}
