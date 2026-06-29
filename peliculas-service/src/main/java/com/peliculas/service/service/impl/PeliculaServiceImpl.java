package com.peliculas.service.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.peliculas.service.dto.PeliculaRequest;
import com.peliculas.service.dto.PeliculaResponse;
import com.peliculas.service.model.mapper.PeliculaMapper;
import com.peliculas.service.repository.PeliculaRepository;
import com.peliculas.service.service.PeliculaService;

@Service
public class PeliculaServiceImpl implements PeliculaService{
	private PeliculaRepository repository;
	
	public PeliculaServiceImpl(PeliculaRepository repository) {
		this.repository=repository;
	}
	
	@Override
	public void registrar(PeliculaRequest peliculaRequest) {
		var entity = PeliculaMapper.MAPPER.toPeliculaEntity(peliculaRequest);
		repository.save(entity);
	}
	
	@Override
	public Iterable<PeliculaResponse> listar(){
		var peliculas=repository.findAll();
		var res=new ArrayList<PeliculaResponse>();
		
		peliculas.forEach(x -> {
			var pelicula=PeliculaMapper.MAPPER.toPeliculaResponse(x);
			res.add(pelicula);
		});
		return res;
	}
	
	@Override
	public void actualizar(PeliculaRequest peliculaRequest) {
		var pelicula=repository.findById(peliculaRequest.getId());
		
		if(!pelicula.isPresent()) {
			throw new RuntimeException("La película no existe.");
		}
		pelicula.get().setTitulo(peliculaRequest.getTitulo());
		pelicula.get().setGenero(peliculaRequest.getGenero());
		pelicula.get().setAno(peliculaRequest.getAno());
		
		repository.save(pelicula.get());
	}
	@Override
	public void eliminar(int id) {
		repository.deleteById(id);
	}
	@Override
	public PeliculaResponse buscarPorId(int id) {
		var pelicula = repository.findById(id);
		if(!pelicula.isPresent()) {
			throw new RuntimeException("La película no existe.");
		}
		return PeliculaMapper.MAPPER.toPeliculaResponse(pelicula.get());
	}
}
