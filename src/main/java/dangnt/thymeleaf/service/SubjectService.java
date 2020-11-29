package dangnt.thymeleaf.service;

import dangnt.thymeleaf.object.accessdata.SubjectDao;
import dangnt.thymeleaf.object.dto.MenuSubjectDto;
import dangnt.thymeleaf.object.dto.PageableAndSortDto;
import dangnt.thymeleaf.object.dto.SubjectDto;
import dangnt.thymeleaf.object.exception.NotFoundException;
import java.util.List;

public interface SubjectService {
  List<MenuSubjectDto> getSubjectMenu();
  SubjectDao getArticleBySubjectId(Long subjectId, PageableAndSortDto pageableAndSortDto)
      throws NotFoundException;
}
