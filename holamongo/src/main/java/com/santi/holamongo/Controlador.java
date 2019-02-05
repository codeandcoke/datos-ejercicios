package com.santi.holamongo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import com.santi.holamongo.domain.Coche;
import com.santi.holamongo.ui.Vista;
import com.santi.holamongo.util.NumeroUtil;

public class Controlador implements ActionListener {
	
	private Modelo modelo;
	private Vista vista;
	
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		
		inicializar();
	}
	
	private void inicializar() {
		vista.botonesCrud.addListeners(this);
		vista.panelBusqueda.listar(modelo.getCoches());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch (comando) {
			case "nuevo":
				break;
			case "guardar":
				try {
					Coche coche = new Coche();
					coche.setMarca(vista.tfMarca.getText());
					coche.setModelo(vista.tfModelo.getText());
					coche.setPrecio(NumeroUtil.parseMoneda(vista.tfPrecio.getText()));
					coche.setFechaCompra(vista.dpFechaCompra.getDate());
					modelo.anadir(coche);
					vista.panelBusqueda.anadir(coche);
				} catch (ParseException pe) {
					pe.printStackTrace();
				}
				break;
			case "cancelar":
				break;
			case "modificar":
				break;
			case "eliminar":
				break;
			default:
		}
	}
}
