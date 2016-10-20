package com.sfaci.concesionario.gui;

import com.sfaci.concesionario.base.Coche;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Modelo para la ventana de la aplicación
 *
 * @author Santiago Faci
 * @version curso 2016-2017
 */
public class VentanaModel {

    private HashMap<String, Coche> coches;
    private final String RUTA_FICHERO =
            System.getProperty("user.home") + File.separator + "coches.dat";

    public VentanaModel() throws FileNotFoundException, ClassNotFoundException,
        IOException {

        File fichero = new File(RUTA_FICHERO);
        if (fichero.exists()) {
            cargarDeFichero();
        }
        else {
            coches = new HashMap<>();
        }
    }

    /**
     * Registra un nuevo coche
     */
    public void registrarCoche(Coche coche) {

        coches.put(coche.getMatricula(), coche);
    }

    public void modificarCoche(Coche nuevoCoche, String matricula) {

        Coche coche = coches.get(matricula);
        coche.setMatricula(nuevoCoche.getMatricula());
        coche.setModelo(nuevoCoche.getModelo());
        coche.setFechaCompra(nuevoCoche.getFechaCompra());
        coche.setPotencia(nuevoCoche.getPotencia());
        coche.setCombustible(nuevoCoche.getCombustible());
        coche.setHibrido(nuevoCoche.isHibrido());
    }

    /**
     * Elimina un coche
     */
    public void eliminarCoche(String matricula) {

        coches.remove(matricula);
    }

    /**
     * Obtiene un coche a partir de su matrícula
     * @param matricula
     * @return
     */
    public Coche obtenerCoche(String matricula) {

        return null;
    }

    /**
     * Obtiene una lista de coches con la información que se busca
     * en matricula y modelo
     * @param busqueda Cadena de búsqueda
     * @return La lista con los coches encontrados o una lista vacía si no
     * encuentra nada
     */
    public ArrayList<Coche> obtenerCoches(String busqueda) {

        ArrayList<Coche> cochesEncontrados = new ArrayList<>();

        for (Coche coche : obtenerCoches()) {
            if ((coche.getMatricula().contains(busqueda))
                || (coche.getModelo().contains(busqueda))) {
                cochesEncontrados.add(coche);
            }
        }

        return cochesEncontrados;
    }

    /**
     * Obtiene una lista con todos los coches
     * @return
     */
    public Collection<Coche> obtenerCoches() {

        return coches.values();
    }

    /**
     * Guarda los datos a un fichero en el disco duro
     * @throws IOException En caso de fallo al escribir en disco
     */
    public void guardarAFichero() throws IOException {

        ObjectOutputStream serializador = null;

        serializador = new ObjectOutputStream(new FileOutputStream(RUTA_FICHERO));
        serializador.writeObject(coches);
        if (serializador != null)
            serializador.close();
    }

    public void cargarDeFichero() throws FileNotFoundException,
        ClassNotFoundException, IOException {

        ObjectInputStream deserializador = null;

        deserializador = new ObjectInputStream(new FileInputStream(RUTA_FICHERO));
        coches = (HashMap<String, Coche>) deserializador.readObject();
        if (deserializador == null)
            deserializador.close();
    }
}
