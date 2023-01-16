package es.iesjandula.springdata.models;

import jakarta.persistence.*;



public class Matricula
{

    private MatriculaId matriculaId;

    private Asignatura idAsignatura;

    private Curso idCurso;

    public Matricula() {
    }

    public MatriculaId getMatriculaId() {
        return matriculaId;
    }

    public void setMatriculaId(MatriculaId matriculaId) {
        this.matriculaId = matriculaId;
    }

    public Asignatura getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Asignatura idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }
}
