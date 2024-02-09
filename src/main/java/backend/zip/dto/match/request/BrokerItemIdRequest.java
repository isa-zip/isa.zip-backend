package backend.zip.dto.match.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BrokerItemIdRequest {
    private List<Long> brokerItemId;
}
