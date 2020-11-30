package dangnt.thymeleaf.object.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectPostKey implements Serializable {
  @Column(name = "subject_id")
  Long subjectId;

  @Column(name = "post_id")
  Long postId;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SubjectPostKey)) return false;
    SubjectPostKey that = (SubjectPostKey) o;
    return Objects.equals(getSubjectId(), that.getSubjectId()) &&
            Objects.equals(getPostId(), that.getPostId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getSubjectId(), getPostId());
  }
}
