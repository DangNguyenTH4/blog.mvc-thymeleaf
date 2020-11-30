package dangnt.thymeleaf.templateutils;

import dangnt.thymeleaf.templateutils.impl.ThymeleafStringTemplateService;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplatePool {
    private static TemplatePool instance = new TemplatePool();
    private int poolSize = 10;
    private final Set<TemplateService> available = new HashSet<>();
    private final Set<TemplateService> inUse = new HashSet<>();

    private TemplatePool(){
        for(int i=0;i<poolSize;i++) {
            available.add(create());
        }
        log.info("Init TemplatePool done! TemplateService size: {}", available.size());
    }

    public static TemplatePool getInstance() {
        return instance;
    }

    public TemplateService get(){

        //Wait for another thread return.
        log.info("Available size: {}", available.size());
        while(available.isEmpty()){
            log.info("Available is empty. Wait!");
        }

        TemplateService templateService = null;
        //Void deadlock.
        synchronized (available) {

            Iterator<TemplateService> iterator = available.iterator();
            if(iterator.hasNext()){
                templateService = iterator.next();
                available.remove(templateService);
            }
            log.info("After get one: {}", available.size());
        }
        if (templateService != null) inUse.add(templateService);
        log.info("Got an instance: {}", templateService);
        return templateService;
    }

    public void release(TemplateService instance){
        inUse.remove(instance);
        available.add(instance);
        log.info("After release templateInstance! Available size: {}", available.size());
    }

    private TemplateService create(){
        return new ThymeleafStringTemplateService();
    }
}
