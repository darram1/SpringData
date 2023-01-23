package es.iesjandula.springdata.Interfaces;

import es.iesjandula.springdata.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfesorRepository extends JpaRepository<Profesor, Long> {

}
