package es.iesjandula.springdata.Interfaces;

import es.iesjandula.springdata.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {

}
