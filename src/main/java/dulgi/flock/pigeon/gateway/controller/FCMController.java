package dulgi.flock.pigeon.gateway.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import dulgi.flock.pigeon.gateway.model.FCMMessageRequest;
import dulgi.flock.pigeon.gateway.model.Token;
import dulgi.flock.pigeon.gateway.service.FCMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class FCMController {
    @Autowired
    FCMService FCMService;

    @PostMapping("/insertNewToken")
    public String TokenControllerInsertNewToken(@RequestBody Token dto){
        FCMService.insertNewTokenService(dto.getUuid(), dto.getToken(), dto.getRegisteredTime());
        return "Token Registered Successfully";
    }

    /**
     * title, body
     */
    @PostMapping("/fcm/message")
    public String sendMessage(@RequestBody FCMMessageRequest request) throws JsonProcessingException {
        return FCMService.sendMessage(request);
    }

    @GetMapping("/fcm/token")
    public String getTokens() throws JsonProcessingException {
        String result = FCMService.getTokens();
//        HttpEntity<String> entity = new HttpEntity<>(result);
        return result;
    }
}
