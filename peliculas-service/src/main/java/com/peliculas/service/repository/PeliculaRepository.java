package com.peliculas.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.peliculas.service.model.entity.PeliculaEntity;

@Repository
public interface PeliculaRepository extends CrudRepository<PeliculaEntity, Integer>{
}