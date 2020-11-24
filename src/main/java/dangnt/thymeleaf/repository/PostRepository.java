package dangnt.thymeleaf.repository;

import dangnt.thymeleaf.object.model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
