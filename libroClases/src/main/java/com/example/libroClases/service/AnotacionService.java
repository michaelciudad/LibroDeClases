package com.example.libroClases.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.libroClases.model.Anotacion;
import com.example.libroClases.repository.AnotacionRepository;

@Service
public class AnotacionService {

	private final AnotacionRepository anotacionRepository;

	public AnotacionService(AnotacionRepository anotacionRepository) {
		this.anotacionRepository = anotacionRepository;
	}

	public Anotacion registrarAnotacion(Anotacion anotacion) {
		return anotacionRepository.save(anotacion);
	}

	public List<Anotacion> obtenerHojaDeVida(Long idEstudiante) {
		return anotacionRepository.findByIdEstudiante(idEstudiante);
	}
}
