package dangnt.thymeleaf.controller;

import dangnt.thymeleaf.object.model.FriendEntity;
import dangnt.thymeleaf.service.FriendService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/friends")
@Slf4j
public class UserController {
  @Autowired private FriendService userService;

  @RequestMapping({"/",""})
  public String index(Model model) {
    List<FriendEntity> users = userService.getAllUser();
//    User user = new User();
//    user.setEmail("dangnt@fsoft.com.vn");
//    user.setId(1L);
//    user.setName("DangNT");
//    user.setPhone("0976949132");
//    users.add(user);
    model.addAttribute("title", "About my friend!");
    model.addAttribute("users", users);

    return "friendlist";
  }

  @RequestMapping(value = "test")
  public String test(Model model) throws InterruptedException {
    log.info("TESTTTTTTTTTTTTTTTTT");
    System.out.println("Tesst2");
    Thread.sleep(3000);
    log.info("Done");

    model.addAttribute("user", new FriendEntity());
    return "addUser";
  }
  @RequestMapping(value = "add")
  public String addUser(Model model) {
    model.addAttribute("user", new FriendEntity());
    model.addAttribute("title", "New friend!!!");
    return "addUser";
  }

  @RequestMapping(value = "/edit", method = RequestMethod.GET)
  public String editUser(@RequestParam("id") Long userId, Model model) {
    Optional<FriendEntity> userEdit = userService.findUserById(userId);
    userEdit.ifPresent(user -> model.addAttribute("user", user));
    return "editUser";
  }

  @RequestMapping(value = "save", method = RequestMethod.POST)
  public String save(FriendEntity user) {
    userService.saveUser(user);
    return "redirect:/friends";
  }

  @RequestMapping(value = "update", method = RequestMethod.POST)
  public String update(FriendEntity user) {
    userService.updateUser(user);
    return "redirect:/friends";
  }


//  @RequestMapping(value = "/delete", method = RequestMethod.GET)
//  public String deleteUser(@RequestParam("id") Long userId, Model model) {
//    userService.deleteUser(userId);
//    return "redirect:/";
//  }
}
