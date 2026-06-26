package com.example.libroClases.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.libroClases.model.Anotacion;
import com.example.libroClases.service.AnotacionService;

@RestController
@RequestMapping("/api/anotaciones")
@CrossOrigin(origins = "*")
public class AnotacionController {

	private final AnotacionService anotacionService;

	public AnotacionController(AnotacionService anotacionService) {
		this.anotacionService = anotacionService;
	}

	@PostMapping
	public ResponseEntity<?> registrarAnotacion(@RequestBody Anotacion anotacion) {
		Anotacion anotacionGuardada = anotacionService.registrarAnotacion(anotacion);
		return ResponseEntity.status(HttpStatus.CREATED).body(anotacionGuardada);
	}

	@GetMapping("/estudiante/{id}")
	public ResponseEntity<?> obtenerHojaDeVida(@PathVariable Long id) {
		List<Anotacion> anotaciones = anotacionService.obtenerHojaDeVida(id);
		return ResponseEntity.ok(anotaciones);
	}
}
