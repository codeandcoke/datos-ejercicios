package com.sfaci.ejercicio1.base;

import java.util.Date;

/**
 * Created by dam on 21/10/16.
 */
public class Alumno {

    public enum Ciclo {
        ASIR, DAM, DAW;
    }

    private String nombre;
    private String apellidos;
    private Date fechaNacimiento;
    private Ciclo ciclo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos;
    }
}
