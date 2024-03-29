package backend.zip.service.brokeritem;

import backend.zip.domain.broker.BrokerItem;
import backend.zip.dto.main.request.CurrentLocationRequest;
import backend.zip.dto.useritem.request.AddUserItemOptionsRequest;

import java.util.List;
import java.util.Set;

public interface BrokerItemShowService {
    List<BrokerItem> findBrokerItemList(Long userId);

    BrokerItem findBrokerItem(Long brokerItemId);

    Long checkBroker();

    Set<String> findDongOfBrokerItem(Long userId);

    List<BrokerItem> findBrokerItemSortedByDong(String dong);

    List<BrokerItem> findBrokerItemByCurrentLocation(Double x, Double y, AddUserItemOptionsRequest addUserItemOptionsRequest);

    List<BrokerItem> findBrokerItemByCurrentLocationNoFilter(Double x, Double y);
}
