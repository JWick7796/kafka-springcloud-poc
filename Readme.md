Problem:-
Order Microservice:-
=====================
Order(orderId, orderPrice, orderItems(String[], customerId, customerAddress, customerName)

APIs
Add order (/api/order/) [post]
AssignDeliveryGuy (/api/order/{orderId}/deliver}



Delivery Microservice
======================
Agent(agentId, agentName)
DeliveryDetails(deliveryId, customerId, orderId, customerName, customerAddress, agentAllocated)

 
Scenario:
When a order is placed, a message should be published to the kafka topic "order-delivery-topic"
and when the data is published to that topic, then the delivery ms should consume the data and update the deliveryDetails table accordingly.

 


Technology Used:-

1. Eureka With Zuul
2. MapStruct
3. Apache Kafka Producer-Consumer Archiecture