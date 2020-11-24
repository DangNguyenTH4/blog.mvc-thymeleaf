package dangnt.thymeleaf.repository;

import dangnt.thymeleaf.object.model.HeaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeaderRepository extends JpaRepository<HeaderEntity, Long> {

}
