package dangnt.thymeleaf.config;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableCaching
@Slf4j
public class CachingConfig {

  /**
   * SimpleCacheManager
   * @return
   */
  @Bean
  public CacheManager cacheManager() {
    SimpleCacheManager cacheManager = new SimpleCacheManager();
//    CompositeCacheManager cacheManager1 = new CompositeCacheManager();
//    CacheManager cacheManager2 = new NoOpCacheManager();
//    CacheManager cacheManager3 = new ConcurrentMapCacheManager();
    cacheManager.setCaches(Arrays.asList(
//        new ConcurrentMapCache("directory"),
        new ConcurrentMapCache("articleMenu")));
    return cacheManager;
  }

  /**
   * Clear cache 5h/time
   */
  @Scheduled(fixedDelay = 5 * 60 * 1000 ,  initialDelay = 500)
//  @Scheduled(cron = "0/10 * * * * ?")
  public void flushCache(){
    flushAllCache();
  }
  @Autowired
  private CacheManager cacheManager;
  private void flushAllCache(){
    log.info("Clear cache at: {}", System.currentTimeMillis());
    cacheManager.getCacheNames().stream().forEach(cacheName ->{
      Cache cache = cacheManager.getCache(cacheName);
      cache.clear();
    });
  }
}