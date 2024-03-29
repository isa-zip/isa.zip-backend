package backend.zip.dto.brokeritem.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

@Getter
@Setter
@Builder
public class AddressResponse {
    private String address;
    private String road_address_name;
    private String postNumber;

    public static AddressResponse of(JSONObject document) {
        JSONObject roadAddressObj = document.optJSONObject("road_address");
        if (roadAddressObj != null) {
            // road_address가 존재하는 경우
            return AddressResponse.builder()
                    .address(document.getJSONObject("address").getString("address_name"))
                    .road_address_name(document.getString("address_name"))
                    .postNumber(roadAddressObj.getString("zone_no"))
                    .build();
        } else {
            // road_address가 존재하지 않는 경우
            return AddressResponse.builder()
                    .address(document.getJSONObject("address").getString("address_name"))
                    .road_address_name(document.getString("address_name"))
                    .build();
        }
    }

}
