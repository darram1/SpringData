package es.iesjandula.springdata.repositorios;

import es.iesjandula.springdata.models.Grado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGradoRepository extends JpaRepository<Grado, Long> {

}
