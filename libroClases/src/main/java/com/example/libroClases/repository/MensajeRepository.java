package com.example.libroClases.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.libroClases.model.Mensaje;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

	List<Mensaje> findByIdDestinatario(Long idDestinatario);
}
