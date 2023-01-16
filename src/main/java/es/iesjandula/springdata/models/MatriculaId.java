package es.iesjandula.springdata.models;

import java.io.Serializable;

public class MatriculaId implements Serializable {
    private static final long serialVersionUID = 674777474745623622L;

    private Long idAlumno;
    private Long idAsignatura;
    private Long idCurso;

    public MatriculaId() {
    }

    public Long getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Long idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Long getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Long idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }
}
