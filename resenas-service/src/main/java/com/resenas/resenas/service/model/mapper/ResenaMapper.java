package com.resenas.resenas.service.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.resenas.resenas.service.dto.ResenaRequest;
import com.resenas.resenas.service.dto.ResenaResponse;
import com.resenas.resenas.service.model.entity.ResenaEntity;

@Mapper
public interface ResenaMapper {
	ResenaMapper MAPPER =Mappers.getMapper(ResenaMapper.class);
	ResenaResponse  toResenaResponse(ResenaEntity entity);
	
	@Mapping(target="id", ignore=true)
	ResenaEntity toResenaEntity(ResenaRequest request);
}
