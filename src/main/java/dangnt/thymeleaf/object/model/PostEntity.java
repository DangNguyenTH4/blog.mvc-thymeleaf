package dangnt.thymeleaf.object.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "post")
@Table(name = "post", schema = "blog")
@Getter
@Setter
public class PostEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "content", columnDefinition="TEXT")
  private String content;

  private String relatedTag;

  private String description;

  @Column(name = "introduction", columnDefinition="TEXT")
  private String introduction;


  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "post_subject",
      joinColumns = @JoinColumn(name = "postId"),
      inverseJoinColumns = @JoinColumn(name = "subjectId"))
  private List<SubjectEntity> subjects = new ArrayList<>();
}
