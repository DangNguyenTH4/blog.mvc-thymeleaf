package dangnt.thymeleaf.service.impl;

import dangnt.thymeleaf.object.model.FriendEntity;
import dangnt.thymeleaf.repository.FriendRepository;
import dangnt.thymeleaf.service.FriendService;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
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
    user.setCreated(Timestamp.from(Instant.now()));
    userRepository.save(user);
  }

  @Override
  public void updateUser(FriendEntity user) {
    if("dangNt1312".equals(user.getUpdateBy())) {
      user.setUpdated(Timestamp.from(Instant.now()));
      userRepository.save(user);
    }
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
