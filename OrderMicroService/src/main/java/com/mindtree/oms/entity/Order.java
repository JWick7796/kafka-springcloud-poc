package com.mindtree.oms.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderTable")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;

	@Column(columnDefinition = "DECIMAL(10,2)")
	private float orderPrice;

	@ElementCollection
	private List<String> orderItems;

	private int customerId;

	private String customerAddress;

	private String customerName;

	public Order() {
		super();
	}

	public Order(long orderId, float orderPrice, List<String> orderItems, int customerId, String customerAddress,
			String customerName) {
		super();
		this.orderId = orderId;
		this.orderPrice = orderPrice;
		this.orderItems = orderItems;
		this.customerId = customerId;
		this.customerAddress = customerAddress;
		this.customerName = customerName;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public float getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(float orderPrice) {
		this.orderPrice = orderPrice;
	}

	public List<String> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<String> orderItems) {
		this.orderItems = orderItems;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderPrice=" + orderPrice + ", orderItems=" + orderItems
				+ ", customerId=" + customerId + ", customerAddress=" + customerAddress + ", customerName="
				+ customerName + "]";
	}

}
