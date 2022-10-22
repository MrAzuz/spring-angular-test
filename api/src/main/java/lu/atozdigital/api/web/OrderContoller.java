package lu.atozdigital.api.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lu.atozdigital.api.dto.OrderDto;
import lu.atozdigital.api.entities.Order;
import lu.atozdigital.api.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderContoller {

	@Autowired
	OrderService orderService;

	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getAllOrders() {

		try {
			List<Order> Orders = orderService.getOrders();

			if (Orders.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(Orders, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/orders")
	public ResponseEntity<Order> createArticle(@RequestBody OrderDto orderDto) {

		try {
			Order order = orderService.addOrder(orderDto);
			return new ResponseEntity<>(order, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
