package dangnt.thymeleaf.object.mapper;

import dangnt.thymeleaf.object.accessdata.SubjectDao;
import dangnt.thymeleaf.object.dto.MenuSubjectDto;
import dangnt.thymeleaf.object.dto.SubjectDto;
import dangnt.thymeleaf.object.model.SubjectEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface SubjectEntityMapper {

  MenuSubjectDto toMenuSubject(SubjectEntity entity);
  SubjectDto toSubjectDto(SubjectEntity entity);
  SubjectDao toSubjectDao(SubjectEntity entity);
  @Mappings({
      @Mapping(target = "sortedPost", ignore = true)
  })
  SubjectDto toSubjectDto(SubjectDao dao);
}
