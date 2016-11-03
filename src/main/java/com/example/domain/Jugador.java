package com.example.domain;

import javax.persistence.*;

/**
 * Created by DAM on 20/10/16.
 */
// para indicar que esta clase se tiene que mapear con una tabla de la base de datos by alfredo
@Entity
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String nacimiento;
    private int canastasTotales;
    private int asistenciasTotales;
    private int rebotesTotales;
    private String posicion;
    @ManyToOne
    private Equipo equipo;

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public Jugador() {

    }

    public Jugador(String nombre, String nacimiento, int canastasTotales, int asistenciasTotales, int rebotesTotales, String posicion) {
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.canastasTotales = canastasTotales;
        this.asistenciasTotales = asistenciasTotales;
        this.rebotesTotales = rebotesTotales;
        this.posicion = posicion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getCanastasTotales() {
        return canastasTotales;
    }

    public void setCanastasTotales(int canastasTotales) {
        this.canastasTotales = canastasTotales;
    }

    public int getAsistenciasTotales() {
        return asistenciasTotales;
    }

    public void setAsistenciasTotales(int asistenciasTotales) {
        this.asistenciasTotales = asistenciasTotales;
    }

    public int getRebotesTotales() {
        return rebotesTotales;
    }

    public void setRebotesTotales(int rebotesTotales) {
        this.rebotesTotales = rebotesTotales;
    }

    public String getPosicion() {
        return posicion;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nacimiento=" + nacimiento +
                ", canastasTotales=" + canastasTotales +
                ", asistenciasTotales=" + asistenciasTotales +
                ", rebotesTotales=" + rebotesTotales +
                ", posicion='" + posicion + '\'' +
                '}';
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}
