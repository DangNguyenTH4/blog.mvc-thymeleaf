package dangnt.thymeleaf.repository;

import dangnt.thymeleaf.object.model.SubjectPostEntity;
import dangnt.thymeleaf.object.model.SubjectPostKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectPostRepository extends JpaRepository<SubjectPostEntity, SubjectPostKey> {

}
