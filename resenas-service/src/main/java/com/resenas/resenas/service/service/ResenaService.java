package com.resenas.resenas.service.service;

import com.resenas.resenas.service.dto.ResenaRequest;
import com.resenas.resenas.service.dto.ResenaResponse;

public interface ResenaService {
	void registrar(ResenaRequest resenaRequest);
	Iterable<ResenaResponse> listar();
	
	void actualizar(ResenaRequest resenaRequest);
	void eliminar(int id);
}
