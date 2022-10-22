package lu.atozdigital.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lu.atozdigital.api.dto.OrderDto;
import lu.atozdigital.api.entities.Order;
import lu.atozdigital.api.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Override
	public List<Order> getOrders() {
		List<Order> orders = new ArrayList<Order>();
		orderRepository.findAll().forEach(orders::add);
		return orders;
	}

	@Override
	public Order addOrder(OrderDto orderDto) {

		Order order = new Order();
		order.setDate(orderDto.getDate());
		order.setReference(orderDto.getReference());
		order.setArticles(orderDto.getArticles());

		return orderRepository.save(order);

	}

	@Override
	public Optional<Order> getOrderById(Long id) {

		return orderRepository.findById(id);
	}

	@Override
	public Order updateOrder(Long id, OrderDto orderDto) {

		Order order = getOrderById(id).get();
		order.setDate(orderDto.getDate());
		order.setReference(orderDto.getReference());
		order.setArticles(orderDto.getArticles());

		return orderRepository.save(order);

	}

}
