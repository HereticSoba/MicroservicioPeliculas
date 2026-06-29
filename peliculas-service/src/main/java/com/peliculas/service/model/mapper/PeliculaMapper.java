package com.peliculas.service.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.peliculas.service.dto.PeliculaRequest;
import com.peliculas.service.dto.PeliculaResponse;
import com.peliculas.service.model.entity.PeliculaEntity;

@Mapper
public interface PeliculaMapper {
	PeliculaMapper MAPPER = Mappers.getMapper(PeliculaMapper.class);
	PeliculaResponse toPeliculaResponse(PeliculaEntity entity);
	
	@Mapping(target="id", ignore = true)
	PeliculaEntity toPeliculaEntity(PeliculaRequest request);
	}
