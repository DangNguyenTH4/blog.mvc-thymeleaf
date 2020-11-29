package dangnt.thymeleaf.object.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "subject_post")
@Table(name = "subject_post", schema = "blog")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectPostEntity extends BaseEntity{
  public SubjectPostEntity(SubjectPostKey id){
    this.id = id;
  }
  public SubjectPostEntity(SubjectEntity subject, PostEntity post){
    this.subject = subject;
    this.post = post;
  }
  @EmbeddedId
  private SubjectPostKey id;

  @ManyToOne
  @MapsId("subjectId")
  @JoinColumn(name = "subject_id")
  private SubjectEntity subject;

  @ManyToOne
  @MapsId("postId")
  @JoinColumn(name = "post_id")
  private PostEntity post;
}
