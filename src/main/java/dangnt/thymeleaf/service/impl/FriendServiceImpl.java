package dangnt.thymeleaf.service.impl;

import dangnt.thymeleaf.object.model.FriendEntity;
import dangnt.thymeleaf.repository.FriendRepository;
import dangnt.thymeleaf.service.FriendService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImpl implements FriendService {
  @Autowired
  private FriendRepository userRepository;

  @Override
  public List<FriendEntity> getAllUser() {
    return (List<FriendEntity>) userRepository.findAll();
  }

  @Override
  public void saveUser(FriendEntity user) {
    userRepository.save(user);
  }

  @Override
  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }

  @Override
  public Optional<FriendEntity> findUserById(Long id) {
    return userRepository.findById(id);
  }
}
