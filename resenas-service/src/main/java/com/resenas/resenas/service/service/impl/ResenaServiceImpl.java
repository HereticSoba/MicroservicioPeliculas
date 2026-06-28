package com.resenas.resenas.service.service.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.resenas.resenas.service.dto.ResenaRequest;
import com.resenas.resenas.service.dto.ResenaResponse;
import com.resenas.resenas.service.model.mapper.ResenaMapper;
import com.resenas.resenas.service.repository.ResenaRepository;
import com.resenas.resenas.service.service.ResenaService;
import com.resenas.resenas.service.client.PeliculaClient;

@Service
public class ResenaServiceImpl implements ResenaService{
	private ResenaRepository repository;
	private PeliculaClient peliculaClient;
	public ResenaServiceImpl(ResenaRepository repository, PeliculaClient peliculaClient) {
		this.repository=repository;
		this.peliculaClient=peliculaClient;
	}
	@Override
	public void registrar(ResenaRequest resenaRequest) {
		var pelicula = peliculaClient.buscarporId(resenaRequest.getPeliculaId());
		if (pelicula== null) {
			throw new RuntimeException("La pelicula no existe.");
		}
		var entity=ResenaMapper.MAPPER.toResenaEntity(resenaRequest);
		repository.save(entity);
	}
	@Override
	public Iterable<ResenaResponse> listar() {
		var resenas=repository.findAll();
		var res=new ArrayList<ResenaResponse>();
		resenas.forEach(x->{
			var resena = ResenaMapper.MAPPER.toResenaResponse(x);
			res.add(resena);
		});
		return res;
	}
	@Override
	public void actualizar(ResenaRequest resenaRequest) {
		var resena=repository.findById(resenaRequest.getId());
		if(!resena.isPresent()) {
			throw new RuntimeException("La reseña no existe.");			
		}
		resena.get().setComentario(resenaRequest.getComentario());
		resena.get().setCalificacion(resenaRequest.getCalificacion());
		resena.get().setPeliculaId(resenaRequest.getPeliculaId());
		
		repository.save(resena.get());
	}
	@Override
	public void eliminar(int id) {
		repository.deleteById(id);
	}

}
