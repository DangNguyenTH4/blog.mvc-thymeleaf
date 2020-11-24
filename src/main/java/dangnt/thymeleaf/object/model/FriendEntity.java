package dangnt.thymeleaf.object.model;

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


  public FriendEntity() {}

  public FriendEntity(String name, String email, String phone, String relationShip) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.relationShip = relationShip;
  }
}
