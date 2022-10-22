package lu.atozdigital.api.service;

import java.util.List;
import java.util.Optional;

import lu.atozdigital.api.dto.OrderDto;
import lu.atozdigital.api.entities.Order;

public interface OrderService {
	
	public List<Order> getOrders();
	public Order addOrder(OrderDto orderDto);
	public Optional<Order> getOrderById(Long id);
	public Order updateOrder(Long id, OrderDto orderDto);
}
