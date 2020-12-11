package dangnt.thymeleaf.controller;

import dangnt.thymeleaf.facade.FacadeApi;
import dangnt.thymeleaf.object.dto.PageDto;
import dangnt.thymeleaf.object.dto.PageableAndSortDto;
import dangnt.thymeleaf.sessionmanager.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/","", "/home"})
@Scope("session")
public class HomeController {
  @Autowired
  private FacadeApi facadeApi;
  @GetMapping
  public String getHome(Model model , @RequestParam(value = "pageIndex", required = false) Integer pageIndex){
    PageableAndSortDto pageableAndSortDto = new PageableAndSortDto();
    pageableAndSortDto.setPageIndex(pageIndex == null ? 0 : pageIndex);
    pageableAndSortDto.setPageSize(10);
    PageDto pageDto = facadeApi.getHome(pageableAndSortDto);
    ControllerUtils.buildModelForPage(model, pageDto);

    if(pageIndex != null){
      return "home::articleList";
    }
    return "home";
  }

  @GetMapping("/page")
  public String getHomePageble(Model model, @RequestParam(value = "pageIndex", required = false) Integer pageIndex){
    PageableAndSortDto pageableAndSortDto = new PageableAndSortDto();
    pageableAndSortDto.setPageIndex(pageIndex == null ? 0 : pageIndex);
    pageableAndSortDto.setPageSize(10);
    PageDto pageDto = facadeApi.getHome(pageableAndSortDto);
    ControllerUtils.buildModelForPage(model, pageDto);
    return "home::articleList";
  }
}
