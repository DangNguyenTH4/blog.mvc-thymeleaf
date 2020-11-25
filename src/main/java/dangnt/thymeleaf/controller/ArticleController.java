package dangnt.thymeleaf.controller;

import dangnt.thymeleaf.facade.FacadeApi;
import dangnt.thymeleaf.object.dto.Article;
import dangnt.thymeleaf.object.dto.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private FacadeApi facadeApi;
    @GetMapping("/{postId}")
    public String getAnArticle(Model model, @PathVariable("postId") Long postId){
        PageDto pageDto = facadeApi.getArticle(postId);
        ControllerUtils.buildModelForPage(model, pageDto);
        return "anArticle";
    }

    @GetMapping("/{year}/{month}")
    public String getArticles(Model model, @PathVariable("year") Integer year,
        @PathVariable("month") Integer month) {
        PageDto pageDto = facadeApi.getArticle(1L);
        ControllerUtils.buildModelForPage(model, pageDto);
        return "anArticle";
    }

    @GetMapping("/{year}/{month}/{postId}")
    public String getAnArticleInMonth(Model model, @PathVariable("year") Integer year,
        @PathVariable("month") Integer month, @PathVariable("postId") Long postId) {
        PageDto pageDto = facadeApi.getArticle(postId);
        ControllerUtils.buildModelForPage(model, pageDto);
        return "anArticle";
    }
}
