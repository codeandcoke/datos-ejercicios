package com.sfaci.ejercicio1.gui;

import com.sfaci.ejercicio1.base.Alumno;

import java.util.ArrayList;

/**
 * Created by dam on 21/10/16.
 */
public class VentanaModel {

    private ArrayList<Alumno> alumnos;

    public VentanaModel() {

        alumnos = new ArrayList<>();
    }

    public void registrar(Alumno alumno) {

        alumnos.add(alumno);
    }

    public ArrayList<Alumno> obtenerAlumnos() {

        return alumnos;
    }
}
