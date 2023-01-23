package es.iesjandula.springdata.models;

import jakarta.persistence.*;

@Entity
@Table(name="asignatura")
public class Asignatura {

    @Id
    @Column(length = 10)
    private long id;

    @Column(length = 10, nullable = false)
    private double creditos;

    @Column(length = 10, nullable = false)
    private int cuatrimestre;

    @Column(length = 10, nullable = false)
    private int curso;

    @Column(length = 25, nullable = false)
    private String nombre;

    @Column(length = 25, nullable = false)
    private String tipo;

    @ManyToOne
    private Grado idGradoId;

    @ManyToOne
    private Profesor idProfesorId;

    public Asignatura() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCreditos() {
        return creditos;
    }

    public void setCreditos(double creditos) {
        this.creditos = creditos;
    }

    public int getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(int cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Grado getIdGradoId() {
        return idGradoId;
    }

    public void setIdGradoId(Grado idGradoId) {
        this.idGradoId = idGradoId;
    }

    public Profesor getIdProfesorId() {
        return idProfesorId;
    }

    public void setIdProfesorId(Profesor idProfesorId) {
        this.idProfesorId = idProfesorId;
    }
}
