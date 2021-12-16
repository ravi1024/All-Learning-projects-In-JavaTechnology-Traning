package com.ravi.springexceptionhandling.service;

import com.ravi.springexceptionhandling.exception.OrderNotFoundException;
import com.ravi.springexceptionhandling.model.Order;
import com.ravi.springexceptionhandling.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @PostConstruct
    public void populateDB() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("Bike", 90000));
        orderList.add(new Order("Mobile", 8000));
        orderRepository.saveAll(orderList);
    }

    public double getPriceOfOrder(String orderName) throws OrderNotFoundException {
        double amount=0;
        try {
            Order order= orderRepository.findByName(orderName);
            amount=order.getPrice();
        }
        catch (Exception e)
        {
            throw new OrderNotFoundException("Order is not found!!!");
        }

        return amount;
    }
}
