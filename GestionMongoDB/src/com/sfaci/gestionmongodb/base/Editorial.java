package com.sfaci.gestionmongodb.base;

import org.bson.types.ObjectId;

import java.util.ArrayList;

/**
 * Created by dam on 16/02/17.
 */
public class Editorial {

    private ObjectId id;
    private String nombre;
    private ArrayList<String> telefonos;

    public Editorial() {
        telefonos = new ArrayList<>();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(ArrayList<String> telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
