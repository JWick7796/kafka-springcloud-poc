package com.mindtree.oms.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mindtree.oms.dto.OrderKafkaDTO;
import com.mindtree.oms.dto.OrderRequestDTO;
import com.mindtree.oms.entity.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {
	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

	Order orderDTOToOrder(OrderRequestDTO dto);

	OrderKafkaDTO orderToOrderDTO(Order order);
}
