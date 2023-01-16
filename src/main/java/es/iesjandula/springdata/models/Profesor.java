package es.iesjandula.springdata.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="profesor")
public class Profesor {
    @Id
    @Column(length = 10)
    private Long id;

    @Column(length = 9, unique = true)
    private String nif;

    @Column(length = 25, nullable = false)
    private String nombre;

    @Column(length = 50, nullable = false)
    private String apellido1;

    @Column(length = 50)
    private String apellido2;

    @Column(length = 25, nullable = false)
    private String ciudad;

    @Column(length = 50, nullable = false)
    private String direccion;

    @Column(length = 9)
    private String telefono;

    @Column(nullable = false)
    private Date fechaNacimiento;

    @Column(length = 1, nullable = false)
    private String sexo;

    @ManyToOne
    private Departamento idDepartamento;

    public Profesor() {
    }
}
