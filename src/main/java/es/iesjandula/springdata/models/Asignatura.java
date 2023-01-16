package es.iesjandula.springdata.models;

public class Asignatura {

    private long id;

    private double creditos;

    private int cuatrimestre;

    private int curso;

    private String nombre;

    private String tipo;

    private long idGradoId;

    private long idProfesorId;

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

    public long getIdGradoId() {
        return idGradoId;
    }

    public void setIdGradoId(long idGradoId) {
        this.idGradoId = idGradoId;
    }

    public long getIdProfesorId() {
        return idProfesorId;
    }

    public void setIdProfesorId(long idProfesorId) {
        this.idProfesorId = idProfesorId;
    }
}
