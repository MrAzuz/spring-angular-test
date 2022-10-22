package lu.atozdigital.api.service;

import java.util.List;

import lu.atozdigital.api.dto.OrderDto;
import lu.atozdigital.api.entities.Order;

public interface OrderService {
	
	public List<Order> getOrders();
	public Order addOrder(OrderDto orderDto);
}
