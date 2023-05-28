package dulgi.flock.pigeon.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class FCMMessageLegacyRequest {
    List<String> registration_ids;
    FCMMessageRequest data;
}
