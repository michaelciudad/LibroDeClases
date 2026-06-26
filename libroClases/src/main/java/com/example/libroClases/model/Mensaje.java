package com.example.libroClases.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "mensajes")
@Data
public class Mensaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long idRemitente;

	@Column(nullable = false)
	private Long idDestinatario;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String contenido;

	@Column(nullable = false)
	private LocalDateTime fecha;
}
