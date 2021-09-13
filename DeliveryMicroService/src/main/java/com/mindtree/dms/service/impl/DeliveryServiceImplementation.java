package com.mindtree.dms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.mindtree.dms.dto.OrderKafkaRequestDTO;
import com.mindtree.dms.dto.mapper.OrderMapper;
import com.mindtree.dms.entity.DeliveryAgent;
import com.mindtree.dms.entity.DeliveryDetails;
import com.mindtree.dms.repository.DeliveryAgentRepository;
import com.mindtree.dms.repository.DeliveryDetailsRepository;
import com.mindtree.dms.service.DeliveryService;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.transaction.Transactional;

@Service
public class DeliveryServiceImplementation implements DeliveryService {

	@Autowired
	DeliveryAgentRepository agentRepository;

	@Autowired
	DeliveryDetailsRepository detailsRepository;

	@Override
	@KafkaListener(topics = "order-delivery-topic", groupId = "json_group", containerFactory = "userKafkaListenerFactory")
	@Transactional
	public void getOrderDetails(@Payload OrderKafkaRequestDTO order, @Headers MessageHeaders headers) {

		DeliveryDetails deliveryDetails = OrderMapper.INSTANCE.orderDTOToOrder(order);
		long randomNum = ThreadLocalRandom.current().nextInt(1, 2 + 1);

		DeliveryAgent agent = agentRepository.findById(randomNum).get();

		deliveryDetails.setAgent(agent);

		List<DeliveryDetails> list = agent.getDeliveries();
		list.add(detailsRepository.saveAndFlush(deliveryDetails));
		agent.setDeliveries(list);
		agentRepository.saveAndFlush(agent);

	}

}
