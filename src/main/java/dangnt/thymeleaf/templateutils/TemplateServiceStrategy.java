package dangnt.thymeleaf.templateutils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;

@Component("TemplateServiceStrategy")
@Slf4j
public class TemplateServiceStrategy {
    public String merge(String template, Context context){
        log.info("Get templateService from pool");
        TemplateService templateService = TemplatePool.getInstance().get();
        String content= "";
        try {
            log.info("do merge: Object: {}. Time: {}", templateService, System.currentTimeMillis());
            content = templateService.merge(template, context);
            log.info("end merge: Object: {}. Time: {}", templateService, System.currentTimeMillis());
        }catch (Exception ex){
            log.info("Got exception when merge. Cause: {}", ex.getMessage());
        }
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        TemplatePool.getInstance().release(templateService);
        return content;
    }

}
