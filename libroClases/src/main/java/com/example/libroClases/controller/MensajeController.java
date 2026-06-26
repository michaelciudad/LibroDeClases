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
import com.example.libroClases.model.Mensaje;
import com.example.libroClases.service.MensajeService;

@RestController
@RequestMapping("/api/mensajes")
@CrossOrigin(origins = "*")
public class MensajeController {

	private final MensajeService mensajeService;

	public MensajeController(MensajeService mensajeService) {
		this.mensajeService = mensajeService;
	}

	@PostMapping
	public ResponseEntity<?> enviarMensaje(@RequestBody Mensaje mensaje) {
		Mensaje mensajeEnviado = mensajeService.enviarMensaje(mensaje);
		return ResponseEntity.status(HttpStatus.CREATED).body(mensajeEnviado);
	}

	@GetMapping("/destinatario/{id}")
	public ResponseEntity<?> obtenerBandejaEntrada(@PathVariable Long id) {
		List<Mensaje> mensajes = mensajeService.obtenerBandejaEntrada(id);
		return ResponseEntity.ok(mensajes);
	}
}
