package com.mindtree.oms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.oms.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
