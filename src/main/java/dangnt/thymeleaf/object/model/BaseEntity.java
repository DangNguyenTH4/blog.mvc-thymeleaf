package dangnt.thymeleaf.object.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity {
  @CreationTimestamp
  @Column(name = "created",
      columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Date created;
  @Column(name = "createdBy", length = 100)
  private String createdBy;

  @UpdateTimestamp
  @Column(name = "updated",
      columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Date updated;

  @Column(name = "updatedBy", length = 100)
  private String updatedBy;
  private Boolean active;
  private String language;

  private String note;
}
