package dangnt.thymeleaf.sessionmanager;

import java.util.Objects;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
@Getter
@Setter
public class User implements Comparable<UUID>{
  private UUID id = UUID.randomUUID();
  private String sessionId;
  private Long initTime = System.currentTimeMillis();
  private Long expireTime = System.currentTimeMillis();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public int compareTo(UUID uuid) {
    return this.id.compareTo(uuid);
  }
}
