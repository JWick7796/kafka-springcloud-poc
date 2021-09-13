package com.mindtree.oms.service;

import com.mindtree.oms.entity.Order;

public interface OrderService {

	Order createOrder(Order order);

	void assignDelivery(long orderId);

}
