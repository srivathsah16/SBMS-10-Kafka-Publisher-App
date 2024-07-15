package com.srivath.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.srivath.model.Order;
import com.srivath.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/addOrder")
	public String publishToKafka(@RequestBody List<Order> orders) {
		return orderService.publishToKafkaTopic(orders);
	}

}
