package com.mindtree.dms.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mindtree.dms.dto.OrderKafkaRequestDTO;
import com.mindtree.dms.entity.DeliveryDetails;

@Mapper(componentModel = "spring")
public interface OrderMapper {
	OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

	DeliveryDetails orderDTOToOrder(OrderKafkaRequestDTO dto);
}