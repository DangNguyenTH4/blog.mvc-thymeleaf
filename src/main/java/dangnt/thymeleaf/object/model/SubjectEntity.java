package dangnt.thymeleaf.object.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "subject")
@Table(name = "subject", schema = "blog")
@Getter
@Setter
public class SubjectEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String description;
  @ManyToMany(mappedBy = "subjects")
  private List<PostEntity> articles = new ArrayList<>();
  private Long parentSubject;
  private Integer index;
}
