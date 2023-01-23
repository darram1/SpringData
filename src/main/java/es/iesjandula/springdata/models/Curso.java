package es.iesjandula.springdata.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="curso")
public class Curso {

    @Id
    @Column(length = 10)
    private long id;

    @Column(length = 25,nullable = false)
    private int anyoFin;

    @Column(length = 25,nullable = false)
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
