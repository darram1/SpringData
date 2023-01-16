package es.iesjandula.springdata.models;

import jakarta.persistence.*;

@Entity
@Table(name = "matricula")
public class Matricula
{
    @EmbeddedId
    private MatriculaId matriculaId;

    @ManyToOne
    @JoinColumn(name="id_alumno")
    @MapsId("idAsignatura")
    private Asignatura idAsignatura;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    @MapsId("idCurso")
    private Curso idCurso;
}
