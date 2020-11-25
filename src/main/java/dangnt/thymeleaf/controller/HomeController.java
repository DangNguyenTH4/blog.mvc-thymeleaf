package dangnt.thymeleaf.controller;

import dangnt.thymeleaf.facade.FacadeApi;
import dangnt.thymeleaf.object.dto.Article;
import dangnt.thymeleaf.object.dto.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/",""})
public class HomeController {
  @Autowired
  private FacadeApi facadeApi;
  @GetMapping
  public String getHome(Model model){
    PageDto pageDto = facadeApi.getArticle(1L);
    model.addAttribute("head", pageDto.getHead());
    model.addAttribute("articleMenu", pageDto.getArticleMenu());
    model.addAttribute("footer", pageDto.getFooter());
    model.addAttribute("topMenu", pageDto.getTopMenu());
    model.addAllAttributes(pageDto.getBody());
    model.addAllAttributes(pageDto.getBody());
    return "home";
  }
}
