package com.example.libroClases.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.libroClases.model.Nota;
import com.example.libroClases.repository.NotaRepository;

@Service
public class NotaService {

	private final NotaRepository notaRepository;

	public NotaService(NotaRepository notaRepository) {
		this.notaRepository = notaRepository;
	}

	public Nota registrarNota(Nota nota) {
		return notaRepository.save(nota);
	}

	public Nota editarNota(Long id, Nota notaActualizada) {
		Nota notaExistente = notaRepository.findById(id).orElse(null);
		if (notaExistente != null) {
			notaExistente.setValorNota(notaActualizada.getValorNota());
			return notaRepository.save(notaExistente);
		}
		return null;
	}

	public List<Nota> obtenerNotasPorEstudiante(Long idEstudiante) {
		return notaRepository.findByIdEstudiante(idEstudiante);
	}
}
