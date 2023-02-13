package es.iesjandula.springdata.repositorios;

import es.iesjandula.springdata.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProfesorRepository extends JpaRepository<Profesor, Long> {
    List<Profesor> findFirstByCiudad(String ciudad);
}
