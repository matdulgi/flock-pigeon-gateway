package dulgi.flock.pigeon.gateway.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class FCMMessageLegacyResponse {
    String multicast_id;
    String success;
    String failure;
    String canonical_ids;
    List<String> results;

}
