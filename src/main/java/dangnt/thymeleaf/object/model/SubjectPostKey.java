package dangnt.thymeleaf.object.model;

import java.io.Serializable;
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
}
