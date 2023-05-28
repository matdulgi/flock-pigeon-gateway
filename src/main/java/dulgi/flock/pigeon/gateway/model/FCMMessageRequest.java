package dulgi.flock.pigeon.gateway.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FCMMessageRequest {
    String title;
    String body;
}
