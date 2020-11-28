package dangnt.thymeleaf.controller;

import dangnt.thymeleaf.facade.FacadeApi;
import dangnt.thymeleaf.object.dto.Article;
import dangnt.thymeleaf.object.dto.PageDto;
import dangnt.thymeleaf.object.dto.PageableAndSortDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/","", "/home"})
public class HomeController {
  @Autowired
  private FacadeApi facadeApi;
  @GetMapping
  public String getHome(Model model){
    PageableAndSortDto pageableAndSortDto = new PageableAndSortDto();
    pageableAndSortDto.setPageIndex(0);
    pageableAndSortDto.setPageSize(10);
    PageDto pageDto = facadeApi.getHome(pageableAndSortDto);
    ControllerUtils.buildModelForPage(model, pageDto);
    return "home";
  }

  @GetMapping("/{pageIndex}")
  public String getHomePageble(Model model, @PathVariable(value = "pageIndex", required = true) int pageIndex){
    PageableAndSortDto pageableAndSortDto = new PageableAndSortDto();
    pageableAndSortDto.setPageIndex(pageIndex);
    pageableAndSortDto.setPageSize(10);
    PageDto pageDto = facadeApi.getHome(pageableAndSortDto);
    ControllerUtils.buildModelForPage(model, pageDto);
    return "home::articleList";
  }
}
