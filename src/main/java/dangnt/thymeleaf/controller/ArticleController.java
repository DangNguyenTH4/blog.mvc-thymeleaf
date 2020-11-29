package dangnt.thymeleaf.controller;

import dangnt.thymeleaf.facade.FacadeApi;
import dangnt.thymeleaf.object.dto.PageDto;
import dangnt.thymeleaf.object.dto.PageableAndSortDto;
import dangnt.thymeleaf.object.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        @PathVariable("month") Integer month, @RequestParam(value = "pageIndex", required = false) Integer pageIndex) {

        PageableAndSortDto pageableAndSortDto = new PageableAndSortDto();
        pageableAndSortDto.setSortBy("created");
        pageableAndSortDto.setPageIndex(pageIndex == null ? 0 : pageIndex);
        pageableAndSortDto.setPageSize(10);
        PageDto pageDto = facadeApi.getArticleByTime(year, month, pageableAndSortDto);
        ControllerUtils.buildModelForPage(model, pageDto);
        if(pageIndex != null){
            return "home::articleList";
        }
        return "home";
    }

    @GetMapping("/{year}/{month}/{postId}")
    public String getAnArticleInMonth(Model model, @PathVariable("year") Integer year,
        @PathVariable("month") Integer month, @PathVariable("postId") Long postId) {
        PageDto pageDto = facadeApi.getArticle(postId);
        ControllerUtils.buildModelForPage(model, pageDto);
        return "anArticle";
    }

    @GetMapping("/subject/{subjectId}")
    public String getAnArticleInMonth(Model model, @PathVariable("subjectId") Long subjectId, @RequestParam(value = "pageIndex", required = false) Integer pageIndex ) {
        PageableAndSortDto pageableAndSortDto = new PageableAndSortDto();
        pageableAndSortDto.setPageSize(10);
        pageableAndSortDto.setSortBy("created");
        pageableAndSortDto.setPageIndex(pageIndex == null ? 0 : pageIndex);

        PageDto pageDto = facadeApi.getArticleBySubjectId(subjectId, pageableAndSortDto);
        ControllerUtils.buildModelForPage(model, pageDto);
        if(pageIndex !=null){
            return "home::articleList";
        }
        return "home";
    }
}
