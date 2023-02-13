package es.iesjandula.springdata.repositorios;

import es.iesjandula.springdata.models.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAlumnoRepository extends JpaRepository<Alumno, Long>
{
    List<Alumno> findAlumnoByNombre(String nombre);

    List<Alumno> findAlumnoByApellido1AndApellido2(String apellido1, String apeliidoo2);

    List<Alumno> findFirst4ByCiudadOOrderByApellido1Desc(String ciudad);

    List<Alumno> findDistinctFirstByNombreAndCiudad(String nombre, String Ciudad);

}
