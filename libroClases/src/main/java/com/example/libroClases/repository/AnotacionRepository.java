package com.example.libroClases.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.libroClases.model.Anotacion;

@Repository
public interface AnotacionRepository extends JpaRepository<Anotacion, Long> {

	List<Anotacion> findByIdEstudiante(Long idEstudiante);
}
