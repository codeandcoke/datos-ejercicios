package com.sfaci.ejemplohibernate.beans;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sfaci.ejemplohibernate.Controlador.Accion;
import com.sfaci.ejemplohibernate.Modelo;
import com.sfaci.ejemplohibernate.base.Personaje;

/**
 * Panel para la gestión de los personajes de la aplicación
 */
public class PanelPersonajes extends JPanel implements ActionListener, MouseListener {
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
	private Accion accion;

	/**
	 * Create the panel.
	 */
	public PanelPersonajes(Modelo modelo) {
		this.modelo = modelo;
		setLayout(null);
		
		botonesCrud = new JBotonesCrud();
		botonesCrud.btEliminar.setActionCommand("eliminar");
		botonesCrud.btCancelar.setActionCommand("cancelar");
		botonesCrud.btGuardar.setActionCommand("guardar");
		botonesCrud.btModificar.setActionCommand("modificar");
		botonesCrud.btNuevo.setActionCommand("nuevo");
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
		
		inicializar();
	}
	
	private void inicializar() {
		botonesCrud.addListeners(this);
		panelBusqueda.addListener(this);
		
		Modelo modelo = new Modelo();
		panelBusqueda.inicializar(modelo.getPersonajes());
		modoEdicion(false);
	}
	
	private void modoEdicion(boolean edicion) {
		tfNombre.setEditable(edicion);
		tfDescripcion.setEditable(edicion);
		tfAtaque.setEditable(edicion);
		tfVida.setEditable(edicion);
		
		botonesCrud.modoEdicion(edicion);
	}
	
	private void cargar(Personaje personaje) {
		tfNombre.setText(personaje.getNombre());
		tfDescripcion.setText(personaje.getDescripcion());
		tfAtaque.setText(String.valueOf(personaje.getAtaque()));
		tfVida.setText(String.valueOf(personaje.getVida()));
		panelAnadirArma.anadirArmas(personaje.getArmas());
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
				accion = Accion.NUEVO;
				modoEdicion(true);
				break;
			case "modificar":
				accion = Accion.MODIFICAR;
				modoEdicion(true);
				break;
			case "guardar":
				String nombre = tfNombre.getText();
				String descripcion = tfDescripcion.getText();
				int vida = Integer.parseInt(tfVida.getText());
				int ataque = Integer.parseInt(tfAtaque.getText());
				
				switch (accion) {
					case NUEVO:
						personaje = new Personaje();
						break;
					case MODIFICAR:
						personaje = panelBusqueda.getSeleccionado();
						break;
				}
				personaje.setNombre(nombre);
				personaje.setDescripcion(descripcion);
				personaje.setVida(vida);
				personaje.setAtaque(ataque);
				personaje.getArmas().addAll(panelAnadirArma.getListadoArmas());
				
				modelo.guardar(personaje);
				panelBusqueda.refrescar();
				break;
			case "eliminar":
				personaje = panelBusqueda.getSeleccionado();
				modelo.eliminar(personaje);
				break;
			case "cancelar":
				modoEdicion(false);
				break;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		Personaje personaje = panelBusqueda.getSeleccionado();
		if (personaje == null)
			return;
		
		cargar(personaje);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
