package dangnt.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/extend/suggest")
public class SuggestArticleController {
    /**
     * Get 10 recent posts.
     */
    @GetMapping("/recent")
    public String getTenRecentPost(){
        return null;
    }
    @GetMapping("/hottest")
    public String getTenHosttest(){
        return null;
    }
}
