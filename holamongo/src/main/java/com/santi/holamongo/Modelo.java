package com.santi.holamongo;

import static com.mongodb.client.model.Filters.eq;
import static com.santi.holamongo.util.Constantes.NOMBRE_BASEDATOS;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.santi.holamongo.domain.Coche;
import com.santi.holamongo.domain.Propietario;

public class Modelo {

	private MongoClient cliente;
	private MongoDatabase db;
	
	public Modelo() {
		conectar();
	}
	
	private void conectar() {
		
		db = cliente.getDatabase(NOMBRE_BASEDATOS);
	}
	
	private void desconectar() {
		cliente.close();
	}
	
	public void modificar(Coche coche) {
		// Para utilizar la función eq hay que importar
		// import static com.mongodb.client.model.Filters.*;
		MongoCollection<Coche> coleccionCoches = db.getCollection("coches", Coche.class);
		coleccionCoches.replaceOne(eq("_id", coche.getId()), coche);
		
		// Otra forma de modificar
		// coleccionCoches.replaceOne(new Document("_id", coche.get_id()), coche);
	}
	
	public void eliminar(Coche coche) {
		MongoCollection<Coche> coleccionCoches = db.getCollection("coches", Coche.class);
		coleccionCoches.deleteOne(eq("_id", coche.getId()));
	}
	
	public void anadir(Coche coche) {		
		Document documento = new Document()
		         .append("marca", coche.getMarca())
		         .append("modelo", coche.getModelo())
		         .append("precio", coche.getPrecio())
		         .append("fecha", coche.getFechaCompra())
		         .append("propietario", coche.getPropietario().getId());
		db.getCollection("coches").insertOne(documento);
		
		Propietario propietario = coche.getPropietario();
		propietario.getCoches().add(coche);
		
		db.getCollection("propietarios").updateOne(new Document("_id", coche.getPropietario().getId()),
		         new Document("$set", new Document("coches", propietario.getCoches())));
	}
	
	public List<Coche> getCoches() {
		MongoCollection<Coche> coleccionCoches = db.getCollection("coches", Coche.class);		
		return coleccionCoches.find().into(new ArrayList<Coche>());
	}
	
	public List<Propietario> getPropietarios() {
		MongoCollection<Propietario> coleccion = db.getCollection("propietarios", Propietario.class);		
		return coleccion.find().into(new ArrayList<Propietario>());
	}
}



