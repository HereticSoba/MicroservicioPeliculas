package com.peliculas.service.service;

import com.peliculas.service.dto.PeliculaRequest;
import com.peliculas.service.dto.PeliculaResponse;

public interface PeliculaService {
	void registrar(PeliculaRequest peliculaRequest);
	Iterable<PeliculaResponse> listar();
	PeliculaResponse buscarPorId(int id);
	void actualizar(PeliculaRequest peliculaRequest);
	void eliminar(int id);
}