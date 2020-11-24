package dangnt.thymeleaf.controller;

import dangnt.thymeleaf.object.model.User;
import dangnt.thymeleaf.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
  @Autowired private UserService userService;

  @RequestMapping("/")
  public String index(Model model) {
    List<User> users = userService.getAllUser();
//    User user = new User();
//    user.setEmail("dangnt@fsoft.com.vn");
//    user.setId(1L);
//    user.setName("DangNT");
//    user.setPhone("0976949132");
//    users.add(user);
    model.addAttribute("title", "hello title");
    model.addAttribute("users", users);

    return "index";
  }

  @RequestMapping(value = "add")
  public String addUser(Model model) {
    model.addAttribute("user", new User());
    return "addUser";
  }

  @RequestMapping(value = "/edit", method = RequestMethod.GET)
  public String editUser(@RequestParam("id") Long userId, Model model) {
    Optional<User> userEdit = userService.findUserById(userId);
    userEdit.ifPresent(user -> model.addAttribute("user", user));
    return "editUser";
  }

  @RequestMapping(value = "save", method = RequestMethod.POST)
  public String save(User user) {
    userService.saveUser(user);
    return "redirect:/";
  }

  @RequestMapping(value = "/delete", method = RequestMethod.GET)
  public String deleteUser(@RequestParam("id") Long userId, Model model) {
    userService.deleteUser(userId);
    return "redirect:/";
  }
}
