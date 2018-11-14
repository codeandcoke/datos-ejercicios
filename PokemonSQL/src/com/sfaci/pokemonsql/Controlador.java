package com.sfaci.pokemonsql;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.sfaci.pokemonsql.base.Pokemon;
import com.sfaci.pokemonsql.base.Pokemon.Tipo;
import com.sfaci.pokemonsql.ui.Login;
import com.sfaci.pokemonsql.ui.Vista;
import com.sfaci.pokemonsql.util.Util;

public class Controlador implements ActionListener, MouseListener {

	private Modelo modelo;
	private Vista vista;
	private File ficheroSeleccionado;
	
	public Controlador(Modelo modelo, Vista vista) {
		this.modelo = modelo;
		this.vista = vista;
		
		addListeners();
		modoEdicion(false);
		
		try {
			modelo.conectar();
			iniciarSesion();	
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		poblarTiposPokemon();
		refrescarLista();
	}
	
	private void iniciarSesion() {
		
		boolean autenticado = false;
		Login login = new Login();
		int intentos = 1;
		
		do {
			login.mostrarDialogo();
			String usuario = login.getUsuario();
			String contrasena = login.getContrasena();
			
			try {
				autenticado = modelo.iniciarSesion(usuario, contrasena);
				if (!autenticado) {
					if (intentos > 2) {
						Util.mensajeError("Limite de intentos superado");
						System.exit(0);
					}
					login.limpiarContrasena();
					login.setMensaje("Usuario/Contraseña incorrectos");
					intentos++;
					continue;
				}
					
			} catch (SQLException sqle) {
				Util.mensajeError("No se ha podido conectar por bla bla bla");
			}
		} while (!autenticado);
	}
	
	private void refrescarLista() {
		
		vista.mPokemons.removeAllElements();
		try {
			for (Pokemon pokemon : modelo.getPokemones()) {
				vista.mPokemons.addElement(pokemon);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			Util.mensajeError("No se pueden cargar los datos de la Base de Datos");
		}
	}
	
	private void poblarTiposPokemon() {
		for (Tipo tipo : Tipo.values())
			vista.cbTipo.addItem(tipo);
	}
	
	private void addListeners() {
		
		vista.btNuevo.addActionListener(this);
		vista.btEditar.addActionListener(this);
		vista.btGuardar.addActionListener(this);
		vista.btCancelar.addActionListener(this);
		vista.btEliminar.addActionListener(this);
		
		vista.lbImagen.addMouseListener(this);
		
		vista.lPokemons.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
			case "nuevo":
				modoEdicion(true);
				break;
			case "editar":
				modoEdicion(true);
				break;
			case "guardar":
				modoEdicion(false);
				if (vista.tfNombre.getText().equals("")) {
					JOptionPane.showMessageDialog(null, 
							"El campo nombre es obligatorio", 
						 	"Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (vista.tfNivel.getText().equals(""))
					vista.tfNivel.setText("0");
				if (vista.tfPeso.getText().equals(""))
					vista.tfPeso.setText("0");
				
				if (!vista.tfNivel.getText().matches("[0-9]*")) {
					JOptionPane.showMessageDialog(null, 
							"El nivel tiene que ser un número", 
							"Error", JOptionPane.ERROR_MESSAGE);
					vista.tfNivel.selectAll();
					vista.tfNivel.requestFocus();
					return;
				}
					
				String nombre = vista.tfNombre.getText();
				Tipo tipo = (Tipo) vista.cbTipo.getSelectedItem();
				int nivel = Integer.parseInt(vista.tfNivel.getText());
				float peso = Float.parseFloat(vista.tfPeso.getText());
				
				String nombreImagen = null;
				if (ficheroSeleccionado != null)
					nombreImagen = ficheroSeleccionado.getName();
				else
					nombreImagen = "nopicture.png";
				
				Pokemon pokemon = new Pokemon();
				pokemon.setNombre(nombre);
				pokemon.setTipo(tipo);
				pokemon.setNivel(nivel);
				pokemon.setPeso(peso);
				pokemon.setImagen(nombreImagen);
				
				try {
					modelo.guardar(pokemon);
					
					
					try {
						Util.copiarImagen(ficheroSeleccionado.getAbsolutePath(), 
								nombreImagen);
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
					
					vista.mPokemons.addElement(pokemon);
				} catch (SQLException sqle) {
					sqle.printStackTrace();
					JOptionPane.showMessageDialog(null, 
							"Error al guardar en la Base de Datos", 
							"Error", JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "cancelar":
				modoEdicion(false);
				break;
			case "eliminar":
				
				break;
			default:
				break;
		}
	}
	
	private void modoEdicion(boolean activo) {
		
		vista.tfNombre.setEditable(!vista.tfNombre.isEditable());
		vista.tfPeso.setEditable(!vista.tfPeso.isEditable());
		vista.tfNivel.setEditable(!vista.tfNivel.isEditable());
		
		if (activo) {
			vista.btNuevo.setEnabled(false);
			vista.btEditar.setEnabled(false);
			vista.btGuardar.setEnabled(true);
			vista.btCancelar.setEnabled(true);
			vista.btEliminar.setEnabled(false);
		}
		else {
			vista.btNuevo.setEnabled(true);
			vista.btEditar.setEnabled(false);
			vista.btGuardar.setEnabled(false);
			vista.btCancelar.setEnabled(false);
			vista.btEliminar.setEnabled(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (e.getSource() == vista.lbImagen) {
			JFileChooser jfc = new JFileChooser();
			if (jfc.showOpenDialog(null) == JFileChooser.CANCEL_OPTION)
				return;
			
			ficheroSeleccionado = jfc.getSelectedFile();
			vista.lbImagen.setIcon(
					new ImageIcon(ficheroSeleccionado.getAbsolutePath()));	
		}
		else if (e.getSource() == vista.lPokemons) {
			vista.btEditar.setEnabled(true);
			vista.btEliminar.setEnabled(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}
