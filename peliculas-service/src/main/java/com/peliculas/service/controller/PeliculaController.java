package com.peliculas.service.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peliculas.service.dto.PeliculaRequest;
import com.peliculas.service.dto.PeliculaResponse;
import com.peliculas.service.service.PeliculaService;
import com.peliculas.service.service.impl.PeliculaServiceImpl;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("v1/peliculas")
@Tag(name = "API de peliculas", description = "APIs para la gestión de películas")
@Server(url = "https://test.com", description = "Servidor de pruebas")
public class PeliculaController {
	private PeliculaService peliculaService;

	public PeliculaController(PeliculaServiceImpl peliculaServiceImpl) {
		peliculaService = peliculaServiceImpl;
	}

	@GetMapping
	@Operation(description = "Endopoint para listar todas las películas", method = "GET")
	public Iterable<PeliculaResponse> listar() {
		return peliculaService.listar();
	}

	@PostMapping("/registrar")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Pelicula registrada correctamente"),
			@ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor"), })
	@Operation(description = "Endpoint para registrar peliculas", method = "POST")
	public void registrar(@RequestBody PeliculaRequest peliculaRequest) {
		peliculaService.registrar(peliculaRequest);
	}

	@PutMapping("/actualizar")
	public void actualizar(@RequestBody PeliculaRequest peliculaRequest) {
		peliculaService.actualizar(peliculaRequest);
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable("id") int id) {
		peliculaService.eliminar(id);
	}
	@GetMapping("/{id}")
	public PeliculaResponse buscarPorId(@PathVariable("id") int id) {
		return peliculaService.buscarPorId(id);
	}
}
