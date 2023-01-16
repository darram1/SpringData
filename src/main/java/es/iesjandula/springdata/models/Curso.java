package es.iesjandula.springdata.models;

public class Curso {
    private long id;

    private int anyoFin;

    private int anyoInicio;

    public Curso() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAnyoFin() {
        return anyoFin;
    }

    public void setAnyoFin(int anyoFin) {
        this.anyoFin = anyoFin;
    }

    public int getAnyoInicio() {
        return anyoInicio;
    }

    public void setAnyoInicio(int anyoInicio) {
        this.anyoInicio = anyoInicio;
    }
}
