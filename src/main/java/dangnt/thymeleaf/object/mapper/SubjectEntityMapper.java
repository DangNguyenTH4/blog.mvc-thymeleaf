package dangnt.thymeleaf.object.mapper;

import dangnt.thymeleaf.object.dto.MenuSubjectDto;
import dangnt.thymeleaf.object.model.SubjectEntity;
import org.mapstruct.Mapper;

@Mapper
public interface SubjectEntityMapper {

  MenuSubjectDto toMenuSubject(SubjectEntity entity);
}
