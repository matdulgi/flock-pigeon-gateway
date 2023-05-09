package dulgi.pigeon.controller;

import dulgi.pigeon.model.Token;
import dulgi.pigeon.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

@RestController
public class TokenController {
    @Autowired
    TokenService tokenService;

    @GetMapping("/goodday")
    public String goodDay(ServletRequest request) {
        return "good day!";
    }
    @PostMapping("/insertNewToken")
    public String TokenControllerInsertNewToken(@RequestBody Token dto){
        tokenService.insertNewTokenService(dto.getUuid(), dto.getToken(), dto.getRegisteredTime());
        return "Token Registered Successfully";
    }
}
