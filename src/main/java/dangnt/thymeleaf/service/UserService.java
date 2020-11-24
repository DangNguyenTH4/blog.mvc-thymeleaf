package dangnt.thymeleaf.service;

import dangnt.thymeleaf.object.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
  List<User> getAllUser();

  void saveUser(User user);

  void deleteUser(Long id);

  Optional<User> findUserById(Long id);
}
