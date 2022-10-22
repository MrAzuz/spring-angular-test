package lu.atozdigital.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import lu.atozdigital.api.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
