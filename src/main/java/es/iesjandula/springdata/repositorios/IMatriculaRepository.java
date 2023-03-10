package es.iesjandula.springdata.repositorios;

import es.iesjandula.springdata.models.Matricula;
import es.iesjandula.springdata.models.MatriculaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMatriculaRepository extends JpaRepository<Matricula, MatriculaId> {

}
