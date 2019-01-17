package com.sfaci.ejemplohibernate.beans;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sfaci.ejemplohibernate.Modelo;
import com.sfaci.ejemplohibernate.base.Personaje;

/**
 * Panel para la gestión de los personajes de la aplicación
 */
public class PanelPersonajes extends JPanel implements ActionListener {
	public JBotonesCrud botonesCrud;
	public JTextField tfNombre;
	public JTextField tfDescripcion;
	public JTextField tfVida;
	public JTextField tfAtaque;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_3;
	public PanelBusqueda<Personaje> panelBusqueda;
	public PanelAnadirArma panelAnadirArma;
	
	private Modelo modelo;

	/**
	 * Create the panel.
	 */
	public PanelPersonajes(Modelo modelo) {
		this.modelo = modelo;
		setLayout(null);
		
		botonesCrud = new JBotonesCrud();
		botonesCrud.setBounds(10, 120, 185, 116);
		add(botonesCrud);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(74, 11, 86, 20);
		add(tfNombre);
		tfNombre.setColumns(10);
		
		tfDescripcion = new JTextField();
		tfDescripcion.setBounds(74, 37, 86, 20);
		add(tfDescripcion);
		tfDescripcion.setColumns(10);
		
		tfVida = new JTextField();
		tfVida.setBounds(74, 63, 86, 20);
		add(tfVida);
		tfVida.setColumns(10);
		
		tfAtaque = new JTextField();
		tfAtaque.setBounds(74, 89, 86, 20);
		add(tfAtaque);
		tfAtaque.setColumns(10);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 10, 37, 14);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Descripci\u00F3n");
		lblNewLabel_1.setBounds(10, 36, 54, 14);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Vida");
		lblNewLabel_2.setBounds(10, 65, 20, 14);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Ataque");
		lblNewLabel_3.setBounds(10, 88, 35, 14);
		add(lblNewLabel_3);
		
		panelBusqueda = new PanelBusqueda<>();
		panelBusqueda.setBounds(245, 139, 258, 150);
		add(panelBusqueda);
		
		panelAnadirArma = new PanelAnadirArma();
		panelAnadirArma.setBounds(205, 11, 258, 116);
		add(panelAnadirArma);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		Personaje personaje = null;
		switch (actionCommand) {
			case "nuevo":
				tfNombre.setText("");
				tfDescripcion.setText("");
				tfVida.setText("");
				tfAtaque.setText("");
				break;
			case "modificar":
				
				break;
			case "guardar":
				String nombre = tfNombre.getText();
				String descripcion = tfDescripcion.getText();
				int vida = Integer.parseInt(tfVida.getText());
				int ataque = Integer.parseInt(tfAtaque.getText());
				
				personaje = new Personaje();
				personaje.setNombre(nombre);
				personaje.setDescripcion(descripcion);
				personaje.setVida(vida);
				personaje.setAtaque(ataque);
				
				modelo.guardar(personaje);
				break;
			case "eliminar":
				personaje = panelBusqueda.getSeleccionado();
				modelo.eliminar(personaje);
				break;
			case "cancelar":
				
				break;
		}
		
	}
}
