package dangnt.thymeleaf.service;

import dangnt.thymeleaf.object.model.FriendEntity;
import java.util.List;
import java.util.Optional;

public interface FriendService {
  List<FriendEntity> getAllUser();

  void saveUser(FriendEntity user);

  void deleteUser(Long id);

  Optional<FriendEntity> findUserById(Long id);
}

