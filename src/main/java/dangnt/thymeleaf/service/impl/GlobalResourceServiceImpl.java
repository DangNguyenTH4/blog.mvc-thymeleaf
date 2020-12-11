package dangnt.thymeleaf.service.impl;

import dangnt.thymeleaf.service.GlobalResourceService;
import dangnt.thymeleaf.sessionmanager.User;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("GlobalResourceServiceImpl")
@Slf4j
public class GlobalResourceServiceImpl implements GlobalResourceService {
    Set<User> allUserForRead = new HashSet<>();
    Set<User> allUserForWrite = new HashSet<>();
    @Override
    public Set<User> getListUserOnline() {
        return this.allUserForRead;
    }

    @Override
    public Long countListUserOnline() {
        return (long)this.allUserForRead.size();
    }

    @Override
    public boolean isExist(User user) {
        return this.allUserForRead.contains(user)
                || this.allUserForWrite.contains(user);
    }

    @Override
    public void addNewUserOnline(User user) {
        user.setExpireTime(user.getExpireTime() + 3600_000);
        this.allUserForWrite.add(user);
        this.allUserForRead.add(user);
    }

    @Override
    public void removeUserLeave(User user) {
        allUserForWrite.remove(user);
    }

    @Override
    public void clearAnonymousUser() {

        Iterator<User> iterator = allUserForWrite.iterator();
        Set<User> removed = new HashSet<>();
        long time = System.currentTimeMillis();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getExpireTime()<time){
                log.info("Clear : {}", user.getSessionId());
                removed.add(user);
                iterator.remove();
            }
        }
        allUserForRead.removeAll(removed);
        removed.clear();
        return;
    }
}
