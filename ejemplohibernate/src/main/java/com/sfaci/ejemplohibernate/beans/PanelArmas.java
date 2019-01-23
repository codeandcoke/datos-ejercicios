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
import com.sfaci.ejemplohibernate.base.Arma;
import com.sfaci.ejemplohibernate.util.Util;

/**
 * Panel principal para gestionar Armas
 */
public class PanelArmas extends JPanel implements ActionListener, MouseListener {
	public JBotonesCrud botonesCrud;
	public JTextField tfNombre;
	public JTextField tfAtaque;
	public JTextField tfDuracion;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_2;
	public PanelBusqueda<Arma> panelBusqueda;
	
	private Modelo modelo;
	private Accion accion;

	public PanelArmas(Modelo modelo) {
		this.modelo = modelo;
		setLayout(null);
		
		botonesCrud = new JBotonesCrud();
		botonesCrud.setBounds(10, 94, 179, 107);
		add(botonesCrud);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(62, 10, 86, 20);
		add(tfNombre);
		tfNombre.setColumns(10);
		
		tfAtaque = new JTextField();
		tfAtaque.setBounds(62, 36, 86, 20);
		add(tfAtaque);
		tfAtaque.setColumns(10);
		
		tfDuracion = new JTextField();
		tfDuracion.setBounds(62, 62, 86, 20);
		add(tfDuracion);
		tfDuracion.setColumns(10);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 10, 37, 14);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Ataque");
		lblNewLabel_1.setBounds(10, 36, 35, 14);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Duraci\u00F3n");
		lblNewLabel_2.setBounds(10, 62, 42, 14);
		add(lblNewLabel_2);
		
		panelBusqueda = new PanelBusqueda<>();
		panelBusqueda.setBounds(208, 124, 258, 150);
		add(panelBusqueda);
		
		botonesCrud.addListeners(this);
		
		inicializar();
	}
	
	private void inicializar() {
		panelBusqueda.inicializar(modelo.getArmas());
		panelBusqueda.addListener(this);
		modoEdicion(false);
	}
	
	private void modoEdicion(boolean edicion) {
		tfNombre.setEditable(edicion);
		tfAtaque.setEditable(edicion);
		tfDuracion.setEditable(edicion);
		
		botonesCrud.modoEdicion(edicion);
	}
	
	/**
	 * Carga el arma que se le pasa como parámetro, que será la que se haya seleccionado
	 * @param arma
	 */
	private void cargar(Arma arma) {
		tfNombre.setText(arma.getNombre());
		tfAtaque.setText(String.valueOf(arma.getAtaque()));
		tfDuracion.setText(String.valueOf(arma.getDuracion()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		
		Arma arma = null;
		switch (actionCommand) {
			case "nuevo":
				tfNombre.setText("");
				tfAtaque.setText("");
				tfDuracion.setText("");
				modoEdicion(true);
				accion = Accion.NUEVO;
				break;
			case "modificar":
				modoEdicion(true);
				accion = Accion.MODIFICAR;
				break;
			case "guardar":
				if (Util.mensajeConfirmacion() == Util.NO)
					return;
				
				String nombre = tfNombre.getText();
				int ataque = Integer.parseInt(tfAtaque.getText());
				int duracion = Integer.parseInt(tfDuracion.getText());
				
				switch (accion) {
					case NUEVO:
						arma = new Arma();
						break;
					case MODIFICAR:
						arma = panelBusqueda.getSeleccionado();
						break;
					default:
						Util.mensajeError("Operación desconocida");
						break;
				}
				arma.setNombre(nombre);
				arma.setAtaque(ataque);
				arma.setDuracion(duracion);
				
				modelo.guardar(arma);
				panelBusqueda.refrescar();
				modoEdicion(false);
				break;
			case "eliminar":
				if (!panelBusqueda.estaSeleccionado())
					return;
				
				if (Util.mensajeConfirmacion() == Util.NO)
					return;
				
				arma = panelBusqueda.getSeleccionado();
				modelo.eliminar(arma);
				panelBusqueda.inicializar(modelo.getArmas());
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
		Arma armaSeleccionada = panelBusqueda.getSeleccionado();
		if (armaSeleccionada == null)
			return;
		
		cargar(armaSeleccionada);
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
