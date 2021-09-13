package com.mindtree.dms.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class DeliveryAgent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long agentId;

	private String name;

	@OneToMany(mappedBy = "agent")
	private List<DeliveryDetails> deliveries;

	public DeliveryAgent(long agentId, String name, List<DeliveryDetails> deliveries) {
		super();
		this.agentId = agentId;
		this.name = name;
		this.deliveries = deliveries;
	}

	public DeliveryAgent() {
	}

	public long getAgentId() {
		return agentId;
	}

	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DeliveryDetails> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<DeliveryDetails> deliveries) {
		this.deliveries = deliveries;
	}

}
