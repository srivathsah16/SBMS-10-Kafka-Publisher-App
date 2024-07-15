package com.srivath.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.srivath.model.Order;
import com.srivath.utils.AppConstants;

@Service
public class OrderService {

	@Autowired
	private KafkaTemplate<String, Order> kafkaTemplate;
	private String topic = AppConstants.TOPIC;

	public String publishToKafkaTopic(List<Order> orders) {
		for (Order order : orders) {
			kafkaTemplate.send(topic, order);
			System.out.println("order - " + order + " pushed into kafka topic.");
		}
		return "Orders pushed into Kafka Topic!";
	}
}
