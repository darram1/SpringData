package es.iesjandula.springdata.Interfaces;

import es.iesjandula.springdata.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepository extends JpaRepository<Curso, Long> {

}
