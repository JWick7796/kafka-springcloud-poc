package com.mindtree.oms.dto;

import java.util.Arrays;

public class OrderRequestDTO {

	private float orderPrice;

	private String[] orderItems;

	private int customerId;

	private String customerAddress;

	private String customerName;

	public OrderRequestDTO() {
	}

	public OrderRequestDTO(float orderPrice, String[] orderItems, int customerId, String customerAddress,
			String customerName) {
		super();
		this.orderPrice = orderPrice;
		this.orderItems = orderItems;
		this.customerId = customerId;
		this.customerAddress = customerAddress;
		this.customerName = customerName;
	}

	public float getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(float orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String[] getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(String[] orderItems) {
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
		return "OrderRequestDTO [orderPrice=" + orderPrice + ", orderItems=" + Arrays.toString(orderItems)
				+ ", customerId=" + customerId + ", customerAddress=" + customerAddress + ", customerName="
				+ customerName + "]";
	}

}
