package com.srivath.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import org.springframework.kafka.support.serializer.JsonSerializer;
import com.srivath.model.Order;
import com.srivath.utils.AppConstants;

@Configuration
public class KafkaProducerConfig {

	// What needs to be done? - We need KafkaTemplate to connect with Kafka
	// Server and execute operations.
	// 1. KafkaTemplate Bean should be created. This KafkaTemplate requires
	// ProducerFactory Object.
	// 2. So, ProducerFactory Bean is needed.

	@Bean
	public KafkaTemplate<String, Order> getKafkaTemplate() {
		return new KafkaTemplate<>(getProducerFactory());
		// NOTE: KafkaTemplate is a class.
	}

	@Bean
	public ProducerFactory<String, Order> getProducerFactory() {
		Map<String, Object> configMap = new HashMap<>();
		configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstants.HOST);
		configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configMap);
		// ProducerFactory is an interface. DefaultKafkaProducerFactory is a class
		// implementing ProducerFactory interface.
	}

}
