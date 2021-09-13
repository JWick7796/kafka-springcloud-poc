package com.mindtree.oms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.oms.dto.OrderRequestDTO;
import com.mindtree.oms.dto.mapper.OrderMapper;
import com.mindtree.oms.entity.Order;
import com.mindtree.oms.service.OrderService;

@RestController
@CrossOrigin
public class OrderMSController {

	@Autowired
	OrderService service;

	@PostMapping("/api/order")
	public ResponseEntity<String> addOrder(@RequestBody OrderRequestDTO orderDetails) {
		Order order = OrderMapper.INSTANCE.orderDTOToOrder(orderDetails);
		System.out.println(orderDetails);
		return new ResponseEntity<String>("Order with id " + service.createOrder(order).getOrderId() + " saved ",
				HttpStatus.OK);
	}

	@GetMapping("/api/order/{orderId}/deliver")
	public ResponseEntity<String> assignOrder(@PathVariable long orderId) {
		service.assignDelivery(orderId);
		return new ResponseEntity<String>("Delivery Agent Assigned", HttpStatus.OK);
	}

}
