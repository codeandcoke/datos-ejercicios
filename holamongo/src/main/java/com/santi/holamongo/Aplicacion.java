package com.santi.holamongo;

import java.util.Arrays;

import com.santi.holamongo.ui.Vista;

public class Aplicacion {
	public static void main(String args[]) {
		Vista vista = new Vista();
		Modelo modelo = new Modelo();		
		Controlador controlador = new Controlador(modelo, vista);
	}
}
