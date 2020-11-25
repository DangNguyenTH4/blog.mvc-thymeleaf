package dangnt.thymeleaf.object.accessdata;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Dao: Data access object
 */
@Getter
@Setter
@NoArgsConstructor
public class PostDao {
  private Long id;
  private String title;
  private Date createDate;

  public PostDao(Long id, String title, Date createDate){
    this.id = id;
    this.title = title;
    this.createDate = createDate;
  }
}
