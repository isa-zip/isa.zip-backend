package backend.zip.controller.itemtab;

import backend.zip.domain.broker.BrokerItem;
import backend.zip.dto.brokeritem.response.BrokerItemResponse;
import backend.zip.dto.brokeritem.response.BrokerItemShowResponse;
import backend.zip.dto.main.request.CurrentLocationRequest;
import backend.zip.global.apipayload.ApiResponse;
import backend.zip.service.brokeritem.BrokerItemShowService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/main")
public class ItemTabController {
    private final BrokerItemShowService brokerItemShowService;

    @Operation(summary = "매물 탭 메인 화면", description = "매물 탭 메인화면에서 현재 위치 주변의 매물 아이템 조회")
    @GetMapping("/item")
    public ApiResponse<BrokerItemShowResponse> getBrokerItems(@RequestBody CurrentLocationRequest currentLocationRequest) {
        List<BrokerItem> brokerItemByCurrentLocation = brokerItemShowService.findBrokerItemByCurrentLocation(currentLocationRequest);
        BrokerItemShowResponse brokerItemShowResponse = BrokerItemShowResponse.of(brokerItemByCurrentLocation);

        return ApiResponse.onSuccess(brokerItemShowResponse);
    }

}