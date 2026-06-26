package com.example.libroClases.service;

import org.springframework.stereotype.Service;
import com.example.libroClases.model.Usuario;
import com.example.libroClases.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Usuario autenticarUsuario(String correo, String password) {
		Usuario usuario = usuarioRepository.findByCorreo(correo);
		if (usuario != null && usuario.getPassword().equals(password)) {
			return usuario;
		}
		return null;
	}

	public Usuario obtenerUsuarioPorId(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}
}
