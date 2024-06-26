package co.shop.majestic.serviceImpl;

import co.shop.majestic.repository.CategoryRepository;
import co.shop.majestic.repository.OrderRepository;
import co.shop.majestic.repository.ProductRepository;
import co.shop.majestic.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public ResponseEntity<Map<String, Object>> getCount() {
        Map<String, Object> map = new HashMap<>();
        map.put("category", categoryRepository.count());
        map.put("product", productRepository.count());
        map.put("orders", orderRepository.count());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
