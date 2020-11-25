package dangnt.thymeleaf.repository;

import dangnt.thymeleaf.object.model.SubjectEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
  @Query(value = "select * from blog.subject s order by s.index", nativeQuery = true)
  List<SubjectEntity> findAllSortedByIndex();
}
