package com.sfaci.gestionmongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.sfaci.gestionmongodb.base.Editorial;
import com.sfaci.gestionmongodb.base.Libro;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Iterator;

import static com.sfaci.gestionmongodb.util.Constantes.*;

/**
 * Created by dam on 10/02/17.
 */
public class VentanaModel {

    private MongoClient servidor;
    private MongoDatabase db;

    public VentanaModel(String nombreBaseDatos) {

        conectar(nombreBaseDatos);
    }

    private void conectar(String nombreBaseDatos) {
        servidor = new MongoClient();
        db = servidor.getDatabase(nombreBaseDatos);
    }

    public void insertarLibro(Libro libro) {

        Document documento = new Document()
                .append(TITULO, libro.getTitulo())
                .append(DESCRIPCION, libro.getDescripcion())
                .append(AUTOR, libro.getAutor())
                .append(FECHA, libro.getFecha())
                .append(DISPONIBLE, libro.isDisponible())
                .append(EDITORIAL, libro.getEditorial().getId());
        db.getCollection(COLECCION_LIBROS).insertOne(documento);
    }

    public void modificarLibro(Libro libro) {

    }

    public void eliminarLibro(Libro libro) {

    }

    public Libro obtenerLibro(String titulo) {

        return null;
    }

    public ArrayList<Libro> obtenerLibros() {

        FindIterable iterable = db.getCollection(COLECCION_LIBROS).find();

        ArrayList<Libro> libros = new ArrayList<>();
        Libro libro = null;
        Iterator<Document> iterLibros = iterable.iterator();
        while (iterLibros.hasNext()) {
            Document documento = iterLibros.next();

            libro = new Libro();
            libro.setId(documento.getObjectId(_ID));
            libro.setTitulo(documento.getString(TITULO));
            libro.setDescripcion(documento.getString(DESCRIPCION));
            libro.setAutor(documento.getString(AUTOR));
            libro.setFecha(documento.getDate(FECHA));
            libro.setDisponible(documento.getBoolean(DISPONIBLE));
            libro.setEditorial(
                    obtenerEditorial(documento.getObjectId(EDITORIAL)));
            libros.add(libro);
        }

        return libros;
    }

    public ArrayList<Libro> obtenerLibros(String busqueda) {

        return null;
    }

    public ArrayList<Editorial> obtenerEditoriales() {

        FindIterable iterable = db.getCollection(COLECCION_EDITORIALES).find();

        ArrayList<Editorial> editoriales = new ArrayList<>();
        Editorial editorial = null;
        Iterator<Document> iterEditoriales = iterable.iterator();
        while (iterEditoriales.hasNext()) {
            Document documento = iterEditoriales.next();

            editorial = new Editorial();
            editorial.setId(documento.getObjectId(_ID));
            editorial.setNombre(documento.getString(NOMBRE));
            editoriales.add(editorial);
        }

        return editoriales;
    }

    public Editorial obtenerEditorial(ObjectId id) {

        Document documento = new Document(_ID, id);
        FindIterable iterable =
                db.getCollection(COLECCION_EDITORIALES).find(documento);

        Iterator<Document> iterEditorial = iterable.iterator();
        if (iterEditorial.hasNext()) {
            Document docEditorial = iterEditorial.next();
            Editorial editorial = new Editorial();
            editorial.setId(docEditorial.getObjectId(_ID));
            editorial.setNombre(docEditorial.getString(NOMBRE));

            return editorial;
        }

        return null;
    }


}
