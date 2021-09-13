package com.mindtree.dms.service;

import org.springframework.messaging.MessageHeaders;

import com.mindtree.dms.dto.OrderKafkaRequestDTO;

public interface DeliveryService {

	void getOrderDetails(OrderKafkaRequestDTO order, MessageHeaders headers);

}