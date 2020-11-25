package dangnt.thymeleaf.repository;

import dangnt.thymeleaf.object.model.HeaderEntity;
import dangnt.thymeleaf.object.model.ImageLinkEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageLinkRepository extends JpaRepository<ImageLinkEntity, Long> {
  List<ImageLinkEntity> findByPostId(Long postId);
}
