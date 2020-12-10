package dangnt.thymeleaf.controller.rest;

import dangnt.thymeleaf.facade.FacadeApi;
import dangnt.thymeleaf.object.dto.responsedto.JsonResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/v1/user-online")
public class UserOnlineController {
    @Autowired
    private FacadeApi facadeApi;
    @GetMapping
    public ResponseEntity<JsonResponseDto> countUserOnline(){
        return facadeApi.countUserOnline();
    }
}
