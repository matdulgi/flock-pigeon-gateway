package dulgi.flock.pigeon.gateway.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dulgi.flock.pigeon.gateway.dao.TokenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenService {

    TokenDAO tokenDAO;
    ObjectMapper objectMapper;

    @Autowired
    public TokenService(TokenDAO tokenDAO, ObjectMapper objectMapper){
        this.tokenDAO = tokenDAO;
        this.objectMapper = objectMapper;
    }

    public void insertNewTokenService(String uuID, String token, String registeredTime){
        tokenDAO.insertNewToken(uuID, token, registeredTime);
    }


}
