package dangnt.thymeleaf.service;

import dangnt.thymeleaf.object.dto.MenuSubjectDto;
import java.util.List;

public interface SubjectService {
  List<MenuSubjectDto> getSubjectMenu();
}
