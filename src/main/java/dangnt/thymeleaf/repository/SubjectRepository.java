package dangnt.thymeleaf.repository;

import dangnt.thymeleaf.object.model.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {

}
