package dangnt.thymeleaf.controller;

import dangnt.thymeleaf.object.dto.PageDto;
import org.springframework.ui.Model;

public class ControllerUtils {
  private ControllerUtils(){}
  public static final void buildModelForPage(Model model, PageDto pageDto){
    model.addAttribute("head", pageDto.getHead());
    model.addAttribute("articleMenu", pageDto.getArticleMenu());
    model.addAttribute("footer", pageDto.getFooter());
    model.addAttribute("topMenu", pageDto.getTopMenu());
    model.addAllAttributes(pageDto.getBody());
  }
}
