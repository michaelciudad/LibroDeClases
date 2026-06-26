package com.example.libroClases.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.libroClases.model.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {

	List<Nota> findByIdEstudiante(Long idEstudiante);
}
