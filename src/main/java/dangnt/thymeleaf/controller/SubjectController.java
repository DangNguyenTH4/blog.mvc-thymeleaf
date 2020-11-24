package dangnt.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    @GetMapping("/{subjectName}")
    public String getSubject(Model model, @PathVariable("subjectName") String subjectName){

        return "subject.html";
    }
}
