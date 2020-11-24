package dangnt.thymeleaf.controller;

import dangnt.thymeleaf.facade.FacadeApi;
import dangnt.thymeleaf.object.dto.Article;
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
        Article article = facadeApi.getArticle(postId);
        model.addAttribute("article", article);
        model.addAllAttributes(article.getContentProperties());
        return "anArticle";
    }
}
