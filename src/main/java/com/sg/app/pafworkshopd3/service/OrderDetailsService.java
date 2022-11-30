package com.sg.app.pafworkshopd3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.app.pafworkshopd3.models.OrderDetails;
import com.sg.app.pafworkshopd3.repository.OrderRepository;

@Service
public class OrderDetailsService {
    @Autowired
    private OrderRepository odSvc;

    public OrderDetails getDiscountedOrderDetails(Integer orderId) {
        return odSvc.getDiscountedOrderDetails(orderId);
    }
}
