package com.example.libroClases.controller;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.libroClases.model.Usuario;
import com.example.libroClases.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

	private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales) {
		String correo = credenciales.get("correo");
		String password = credenciales.get("password");

		Usuario usuario = usuarioService.autenticarUsuario(correo, password);
		if (usuario != null) {
			return ResponseEntity.ok(usuario);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> obtenerUsuario(@PathVariable Long id) {
		Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
		if (usuario != null) {
			return ResponseEntity.ok(usuario);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
	}
}
