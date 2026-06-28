package com.resenas.resenas.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.resenas.resenas.service.model.entity.ResenaEntity;

@Repository
public interface ResenaRepository extends CrudRepository<ResenaEntity, Integer>{
}
