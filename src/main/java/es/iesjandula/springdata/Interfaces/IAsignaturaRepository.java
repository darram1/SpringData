package es.iesjandula.springdata.Interfaces;

import es.iesjandula.springdata.models.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAsignaturaRepository extends JpaRepository<Asignatura, Long> {

}
