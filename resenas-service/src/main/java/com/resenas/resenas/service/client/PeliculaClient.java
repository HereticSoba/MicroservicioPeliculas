package com.resenas.resenas.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.resenas.resenas.service.config.FeignConfig;
import com.resenas.resenas.service.dto.PeliculaResponse;

@FeignClient(name="peliculas-service", configuration = FeignConfig.class//,url="http://localhost:8081" 
)
public interface PeliculaClient {
	@GetMapping("/v1/peliculas/{id}")
	PeliculaResponse buscarporId(@PathVariable("id") int id);
}

//He probado que sin la url del localhost el programa sigue funcionando sin problemas,
//con Eureka no es necesario tenerlo ahí.