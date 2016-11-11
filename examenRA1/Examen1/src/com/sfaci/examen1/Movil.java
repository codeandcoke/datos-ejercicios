package com.sfaci.examen1;

import java.util.Date;

/**
 * Created by dam on 11/11/16.
 */
public class Movil {

    private String marca;
    private String modelo;
    private float precio;
    private Date fechaCompra;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    @Override
    public String toString() {
        return marca + " " + modelo;
    }
}
