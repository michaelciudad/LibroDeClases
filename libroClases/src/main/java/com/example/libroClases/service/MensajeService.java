package com.example.libroClases.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.libroClases.model.Mensaje;
import com.example.libroClases.repository.MensajeRepository;

@Service
public class MensajeService {

	private final MensajeRepository mensajeRepository;

	public MensajeService(MensajeRepository mensajeRepository) {
		this.mensajeRepository = mensajeRepository;
	}

	public Mensaje enviarMensaje(Mensaje mensaje) {
		return mensajeRepository.save(mensaje);
	}

	public List<Mensaje> obtenerBandejaEntrada(Long idDestinatario) {
		return mensajeRepository.findByIdDestinatario(idDestinatario);
	}
}
