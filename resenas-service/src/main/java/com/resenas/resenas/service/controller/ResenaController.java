package com.resenas.resenas.service.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resenas.resenas.service.dto.ResenaRequest;
import com.resenas.resenas.service.dto.ResenaResponse;
import com.resenas.resenas.service.service.ResenaService;
import com.resenas.resenas.service.service.impl.ResenaServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("v1/resenas")
@Tag(name="API de Reseñas", description = "APIs para la gestión de reseñas")
@Server(url="https://test.com", description = "Servidor de pruebas")
public class ResenaController {
	private ResenaService resenaService;
	public ResenaController(ResenaServiceImpl resenaServiceImpl) {
		this.resenaService=resenaServiceImpl;
	}
	
	@GetMapping
	@Operation(description = "Endpoint para listar todas las reseñas", method = "GET")
	public Iterable<ResenaResponse> listar(){
		return resenaService.listar();
	}
	
	@PostMapping("/registrar")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Reseña registrada correctamente"),
			@ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor"),
	})
	@Operation(description = "Endpoint para registrar reseñas", method = "POST")
	public void registrar(@RequestBody ResenaRequest resenaRequest) {
		resenaService.registrar(resenaRequest);
	}
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody ResenaRequest resenaRequest) {
		resenaService.actualizar(resenaRequest);
	}
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id")int id) {
		resenaService.eliminar(id);
	}
}
