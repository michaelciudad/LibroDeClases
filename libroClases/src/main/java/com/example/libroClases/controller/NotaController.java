package com.example.libroClases.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.libroClases.model.Nota;
import com.example.libroClases.service.NotaService;

@RestController
@RequestMapping("/api/notas")
@CrossOrigin(origins = "*")
public class NotaController {

	private final NotaService notaService;

	public NotaController(NotaService notaService) {
		this.notaService = notaService;
	}

	@PostMapping
	public ResponseEntity<?> registrarNota(@RequestBody Nota nota) {
		Nota notaGuardada = notaService.registrarNota(nota);
		return ResponseEntity.status(HttpStatus.CREATED).body(notaGuardada);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editarNota(@PathVariable Long id, @RequestBody Nota notaActualizada) {
		Nota notaEditada = notaService.editarNota(id, notaActualizada);
		if (notaEditada != null) {
			return ResponseEntity.ok(notaEditada);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nota no encontrada");
	}

	@GetMapping("/estudiante/{id}")
	public ResponseEntity<?> obtenerNotasPorEstudiante(@PathVariable Long id) {
		List<Nota> notas = notaService.obtenerNotasPorEstudiante(id);
		return ResponseEntity.ok(notas);
	}
}
