package dangnt.thymeleaf.repository;

import dangnt.thymeleaf.object.model.HeaderEntity;
import dangnt.thymeleaf.object.model.MetadataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetadataRepository extends JpaRepository<MetadataEntity, Long> {

}
