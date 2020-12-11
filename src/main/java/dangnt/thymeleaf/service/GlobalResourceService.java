package dangnt.thymeleaf.service;

import dangnt.thymeleaf.sessionmanager.User;
import java.util.Set;

public interface GlobalResourceService {
    Set<User> getListUserOnline();
    //Why long?? ==> Target need long to save user :)))
    Long countListUserOnline();
    boolean isExist(User user);
    void addNewUserOnline(User user);
    void removeUserLeave(User user);
    void clearAnonymousUser();
}
