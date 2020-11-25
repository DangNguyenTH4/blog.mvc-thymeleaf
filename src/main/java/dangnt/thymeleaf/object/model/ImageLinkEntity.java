package dangnt.thymeleaf.object.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "img_link")
@Table(name = "img_link", schema = "blog")
@Getter
@Setter
public class ImageLinkEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String link;

  private Long postId;

}
