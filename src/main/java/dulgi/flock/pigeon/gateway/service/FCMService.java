package dulgi.flock.pigeon.gateway.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dulgi.flock.pigeon.gateway.dao.FCMDAO;
import dulgi.flock.pigeon.gateway.model.FCMMessageLegacyRequest;
import dulgi.flock.pigeon.gateway.model.FCMMessageLegacyResponse;
import dulgi.flock.pigeon.gateway.model.FCMMessageRequest;
import dulgi.flock.pigeon.gateway.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FCMService {

    @Autowired
    FCMDAO FCMDAO;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    RestTemplate restTemplate;
    String fcmLegacyURLStr = "https://fcm.googleapis.com/fcm/send";

    @Value("${fcm.apikey}")
    String fcmApiKey;

    public void insertNewTokenService(String uuID, String token, String registeredTime){
        FCMDAO.insertNewToken(uuID, token, registeredTime);
    }

    public String sendMessage(FCMMessageRequest request) throws JsonProcessingException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", fcmApiKey);
        headers.add("Content-Type", "application/json");
        List<String> tokens = getTokensAsRegistrationIds();
        FCMMessageLegacyRequest lagacyRequest = FCMMessageLegacyRequest.builder().registration_ids(tokens).data(request).build();
        String json = objectMapper.writeValueAsString(lagacyRequest);

        HttpEntity<String> entity = new HttpEntity<>(json, headers);
        ResponseEntity<String> response = restTemplate.exchange(fcmLegacyURLStr, HttpMethod.POST, entity, String.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            String responseBody = response.getBody();
            System.out.println(responseBody);
//            FCMMessageLegacyResponse responseObj = objectMapper.readValue(responseBody, FCMMessageLegacyResponse.class);
            return "good";
        } else {
            System.err.println("Request failed with status code: " + response.getStatusCodeValue());
            return "bad";
        }
    }

    public String getTokens() throws JsonProcessingException {
        List<Token> tokens =  FCMDAO.getTokens();
        return objectMapper.writeValueAsString(tokens);
    }

    public List<String> getTokensAsRegistrationIds() throws JsonProcessingException {
        List<Token> tokens = FCMDAO.getTokens();
        return tokens.stream().map(t -> t.getToken()).collect(Collectors.toList());
    }
}
