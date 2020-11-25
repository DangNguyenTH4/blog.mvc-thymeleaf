package dangnt.thymeleaf.repository;

import dangnt.thymeleaf.object.accessdata.PostDao;
import dangnt.thymeleaf.object.model.PostEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
//  @Query(value = "SELECT new dangnt.thymeleaf.object.accessdata.PostDao(p.id, p.title, p.created) from PostEntity p", nativeQuery = true)
//  List<PostDao> getAllPostDao();
  @Query(value = "Select p.* from blog.post p order by id", nativeQuery = true)
  List<PostEntity> findAllOrderById();
}
