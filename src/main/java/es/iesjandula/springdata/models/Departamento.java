package es.iesjandula.springdata.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "departamento")
public class Departamento
{
    @Id
    @Column(length = 10)
    private Long id;

    @Column(length = 25, nullable = false)
    private String nombre;
}
