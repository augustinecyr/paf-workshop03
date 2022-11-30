package com.sg.app.pafworkshopd3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.app.pafworkshopd3.models.OrderDetails;
import com.sg.app.pafworkshopd3.service.OrderDetailsService;

@RestController
@RequestMapping(path = "/order/total", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderDetailsRESTController {

    @Autowired
    private OrderDetailsService odSvc;

    @GetMapping(path = "{orderId}")
    public ResponseEntity<String> getAllCustomer(@PathVariable Integer orderId) {
        OrderDetails ord = odSvc.getDiscountedOrderDetails(orderId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(ord.toJSON().toString());
    }
}
