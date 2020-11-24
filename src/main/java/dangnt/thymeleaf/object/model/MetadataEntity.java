package dangnt.thymeleaf.object.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "meta_data")
@Table(name = "meta_data", schema = "blog")
@Getter
@Setter
public class MetadataEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String properties;
  private String content;

  private Long postId;
}
