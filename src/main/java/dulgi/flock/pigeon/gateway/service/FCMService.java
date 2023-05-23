package dulgi.flock.pigeon.gateway.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dulgi.flock.pigeon.gateway.dao.FCMDAO;
import dulgi.flock.pigeon.gateway.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FCMService {

    @Autowired
    FCMDAO FCMDAO;
    @Autowired
    ObjectMapper objectMapper;

    public void insertNewTokenService(String uuID, String token, String registeredTime){
        FCMDAO.insertNewToken(uuID, token, registeredTime);
    }

    public String getTokens() throws JsonProcessingException {
        List<Token> tokens =  FCMDAO.getTokens();
        return objectMapper.writeValueAsString(tokens);
    }

}
