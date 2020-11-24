package dangnt.thymeleaf.object.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "friend")
public class FriendEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "email")
  private String email;

  @Column(name = "phone")
  private String phone;

  private String relationShip;

  private String createBy;

  private Timestamp created;
  private Timestamp updated;

  private String updateBy;

  public FriendEntity() {}

  public FriendEntity(String name, String email, String phone, String relationShip, String createBy) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.relationShip = relationShip;
    this.createBy = createBy;
  }
}
