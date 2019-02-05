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

public class Modelo {

	private MongoClient cliente;
	private MongoDatabase db;
	
	public Modelo() {
		conectar();
	}
	
	private void conectar() {
		CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		cliente = new MongoClient("localhost", 
				MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
		db = cliente.getDatabase(NOMBRE_BASEDATOS);
	}
	
	private void desconectar() {
		cliente.close();
	}
	
//	public void anadir(Coche coche) {
//		Document documento = new Document()
//				.append("marca", coche.getMarca())
//				.append("modelo", coche.getModelo())
//				.append("fecha_compra", coche.getFechaCompra())
//				.append("precio", coche.getPrecio());
//		db.getCollection("coches").insertOne(documento);
//	}
	
	public void modificar(Coche coche) {
		// Para utilizar la función eq hay que importar
		// import static com.mongodb.client.model.Filters.*;
		MongoCollection<Coche> coleccionCoches = db.getCollection("coches", Coche.class);
		coleccionCoches.replaceOne(eq("_id", coche.get_id()), coche);
		
		// Otra forma de modificar
		// coleccionCoches.replaceOne(new Document("_id", coche.get_id()), coche);
	}
	
	public void eliminar(Coche coche) {
		MongoCollection<Coche> coleccionCoches = db.getCollection("coches", Coche.class);
		coleccionCoches.deleteOne(eq("_id", coche.get_id()));
	}
	
	public void anadir(Coche coche) {
		MongoCollection<Coche> coleccionCoches = db.getCollection("coches", Coche.class);
		coleccionCoches.insertOne(coche);
	}
	
	public List<Coche> getCoches() {
		MongoCollection<Coche> coleccionCoches = db.getCollection("coches", Coche.class);		
		return coleccionCoches.find().into(new ArrayList<Coche>());
	}
}



