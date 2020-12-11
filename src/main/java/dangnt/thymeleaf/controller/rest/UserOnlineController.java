package dangnt.thymeleaf.controller.rest;

import dangnt.thymeleaf.facade.FacadeApi;
import dangnt.thymeleaf.object.dto.responsedto.JsonResponseDto;
import dangnt.thymeleaf.sessionmanager.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@RestController
@RequestMapping("/rest/v1/user-online")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class UserOnlineController {
    @Autowired
    private FacadeApi facadeApi;
    @Autowired
    private User user;
    @GetMapping
    public ResponseEntity<JsonResponseDto> countUserOnline(){
        return facadeApi.countUserOnline(user);
    }
//    @PostMapping
//    public ResponseEntity<JsonResponseDto> addNewUserJoined(){
//        facadeApi.addNewUserOnline(user);
//        return ResponseEntity.ok(new JsonResponseDto());
//    }
    @DeleteMapping
    public ResponseEntity<JsonResponseDto> deleteUserLeave(){
        facadeApi.removeUserLeave(user);
        return ResponseEntity.ok(new JsonResponseDto());
    }
}
