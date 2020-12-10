package dangnt.thymeleaf.config;

import dangnt.thymeleaf.service.GlobalResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserOnlineConfig {
    /**
     * Clear anonymous user 10mins/time
     */
    @Scheduled(fixedDelay = 600 * 1000 ,  initialDelay = 500)
    public void clearAnonymous(){
        removeUser();
    }

    @Autowired
    private GlobalResourceService globalResourceService;
    private void removeUser(){
        log.info("Clear anonymous user at: {}", System.currentTimeMillis());
        globalResourceService.clearAnonymousUser();
    }
}
