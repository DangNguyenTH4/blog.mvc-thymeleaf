package dangnt.thymeleaf.repository;

import dangnt.thymeleaf.object.accessdata.PostDao;
import dangnt.thymeleaf.object.model.PostEntity;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
//  @Query(value = "SELECT new dangnt.thymeleaf.object.accessdata.PostDao(p.id, p.title, p.created) from PostEntity p", nativeQuery = true)
//  List<PostDao> getAllPostDao();
  @Query(value = "Select p.* from blog.post p order by id", nativeQuery = true)
  List<PostEntity> findAllOrderById();

  @Query(value = "Select p.* from blog.post p where p.id in :postIds order by p.created desc", nativeQuery = true)
  List<PostEntity> findByIdIn(@Param("postIds") List<Long> postId);

  @Query(value = "select p.* from blog.post p where extract(month from p.created) = :month", nativeQuery = true)
  List<PostEntity> findByMonthCreate(@Param("month") Integer month, Pageable pageable);


  List<PostEntity> findByCreatedBetween(Date startDate, Date toDate, Pageable pageable);

//  @Query(value = "SELECT p from blog.post p WHERE p.subject.id = :subjectId ")
//  List<PostEntity> findBySubjectId(@Param("subjectId") Long subjectId);
}
