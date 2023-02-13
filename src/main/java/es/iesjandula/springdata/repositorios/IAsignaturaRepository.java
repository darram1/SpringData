package es.iesjandula.springdata.repositorios;

import es.iesjandula.springdata.models.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAsignaturaRepository extends JpaRepository<Asignatura, Long>
{
    List<Asignatura> findAllByNombreOrderByCursoAsc();

    List<Asignatura> findByCuatrimestreAndTipo();

}
