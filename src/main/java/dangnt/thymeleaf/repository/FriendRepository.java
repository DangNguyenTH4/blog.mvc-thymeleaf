package dangnt.thymeleaf.repository;

import dangnt.thymeleaf.object.model.FriendEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<FriendEntity, Long> {

}
