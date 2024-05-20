package co.shop.majestic.service;


import co.shop.majestic.model.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface OrderService {

    ResponseEntity<String> generate (Map<String, Object> requestMap);

    ResponseEntity<List<Order>> getOrders();
}
