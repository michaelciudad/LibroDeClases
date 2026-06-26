package com.example.libroClases.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "notas")
@Data
public class Nota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long idEstudiante;

	@Column(nullable = false)
	private Long idDocente;

	@Column(nullable = false)
	private Double valorNota;

	@Column(nullable = false)
	private Long idAsignatura;
}
