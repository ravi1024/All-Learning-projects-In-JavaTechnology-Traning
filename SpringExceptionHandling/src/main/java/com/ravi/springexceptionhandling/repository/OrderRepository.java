package com.ravi.springexceptionhandling.repository;

import com.ravi.springexceptionhandling.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {

    public Order findByName(String orderName);
}
