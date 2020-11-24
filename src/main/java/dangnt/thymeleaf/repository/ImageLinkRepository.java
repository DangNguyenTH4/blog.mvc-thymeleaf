package dangnt.thymeleaf.repository;

import dangnt.thymeleaf.object.model.HeaderEntity;
import dangnt.thymeleaf.object.model.ImageLinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageLinkRepository extends JpaRepository<ImageLinkEntity, Long> {

}
