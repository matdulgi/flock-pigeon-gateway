package dulgi.pigeon.service;

import dulgi.pigeon.dao.TokenDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    TokenDAO tokenDAO;



    public void insertNewTokenService(String uuID, String token, String registeredTime){
        tokenDAO.insertNewToken(uuID, token, registeredTime);
    }

}
