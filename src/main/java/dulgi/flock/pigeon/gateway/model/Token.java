package dulgi.flock.pigeon.gateway.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Token {
    private String uuid;
    private String token;
    private String registeredTime;
}

