package es.iesjandula.springdata.repositorios;

import es.iesjandula.springdata.models.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartamentoRepository extends JpaRepository<Departamento, Long> {

}
