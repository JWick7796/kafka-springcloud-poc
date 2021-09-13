package com.mindtree.dms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DeliveryDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long deliveryId;

	private long orderId;

	private int customerId;

	private String customerName;

	private String customerAddress;

	@ManyToOne
	private DeliveryAgent agent;

	public DeliveryDetails(long orderId, int customerId, String customerName, String customerAddress,
			DeliveryAgent agent) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.agent = agent;
	}

	public DeliveryDetails() {
	}

	public long getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(long deliveryId) {
		this.deliveryId = deliveryId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public DeliveryAgent getAgent() {
		return agent;
	}

	public void setAgent(DeliveryAgent agent) {
		this.agent = agent;
	}

}
