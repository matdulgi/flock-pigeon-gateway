package dulgi.flock.pigeon.gateway.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import dulgi.flock.pigeon.gateway.model.Token;
import dulgi.flock.pigeon.gateway.service.FCMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

@RestController
public class FCMController {
    @Autowired
    FCMService FCMService;

    @GetMapping("/goodday")
    public String goodDay(ServletRequest request) {
        return "good day!";
    }
    @PostMapping("/insertNewToken")
    public String TokenControllerInsertNewToken(@RequestBody Token dto){
        FCMService.insertNewTokenService(dto.getUuid(), dto.getToken(), dto.getRegisteredTime());
        return "Token Registered Successfully";
    }

    @GetMapping("/fcm/token")
    public String getTokens() throws JsonProcessingException {
        String result = FCMService.getTokens();
//        HttpEntity<String> entity = new HttpEntity<>(result);
        return result;
    }
}
