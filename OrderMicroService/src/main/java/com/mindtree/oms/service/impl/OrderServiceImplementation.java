package com.mindtree.oms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.mindtree.oms.dto.OrderKafkaDTO;
import com.mindtree.oms.dto.mapper.OrderMapper;
import com.mindtree.oms.entity.Order;
import com.mindtree.oms.repository.OrderRepository;
import com.mindtree.oms.service.OrderService;

@Service
public class OrderServiceImplementation implements OrderService {

	@Autowired
	OrderRepository repository;

	@Autowired
	private KafkaTemplate<String, OrderKafkaDTO> kafkaTemplate;

	@Override
	public Order createOrder(Order order) {
		System.out.println(order);
		Order savedOrder = repository.saveAndFlush(order);
		return savedOrder;
	}

	@Override
	public void assignDelivery(long orderId) {

		OrderKafkaDTO response = OrderMapper.INSTANCE.orderToOrderDTO(repository.findById(orderId).get());

//		kafkaTemplate.send("order-delivery-topic", response);
		Message<OrderKafkaDTO> message = MessageBuilder.withPayload(response)
				.setHeader(KafkaHeaders.TOPIC, "order-delivery-topic").build();
		kafkaTemplate.send(message);
	}
}
