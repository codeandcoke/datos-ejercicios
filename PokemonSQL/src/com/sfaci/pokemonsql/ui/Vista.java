package com.sfaci.pokemonsql.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.sfaci.pokemonsql.base.Pokemon;

public class Vista extends JFrame {

	JFrame ventana;
	public JTextField tfNombre;
	public JTextField tfNivel;
	public JTextField tfPeso;
	public JButton btEditar;
	public JComboBox<Pokemon.Tipo> cbTipo;
	public JScrollPane scrollPane;
	public JList<Pokemon> lPokemons;
	public DefaultListModel<Pokemon> mPokemons;
	public JLabel lbImagen;
	public JButton btEliminar;
	public JButton btNuevo;
	public JButton btGuardar;
	public JButton btCancelar;

	public Vista() {
		ventana = new JFrame();
		ventana.setBounds(100, 100, 450, 366);
		ventana.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre*");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 31, 57, 14);
		ventana.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo");
		lblNewLabel_1.setBounds(10, 62, 46, 14);
		ventana.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nivel");
		lblNewLabel_2.setBounds(10, 93, 46, 14);
		ventana.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Peso");
		lblNewLabel_3.setBounds(10, 124, 46, 14);
		ventana.getContentPane().add(lblNewLabel_3);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(66, 28, 86, 20);
		ventana.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfNivel = new JTextField();
		tfNivel.setBounds(66, 90, 86, 20);
		ventana.getContentPane().add(tfNivel);
		tfNivel.setColumns(10);
		
		tfPeso = new JTextField();
		tfPeso.setBounds(66, 121, 86, 20);
		ventana.getContentPane().add(tfPeso);
		tfPeso.setColumns(10);
		
		btEditar = new JButton("");
		btEditar.setIcon(new ImageIcon("C:\\Users\\Profesor\\Downloads\\open_icon_library-standard-0.11\\open_icon_library-standard\\icons\\png\\32x32\\actions\\edit.png"));
		btEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btEditar.setActionCommand("editar");
		btEditar.setBounds(66, 173, 50, 41);
		ventana.getContentPane().add(btEditar);
		
		cbTipo = new JComboBox<>();
		cbTipo.setBounds(66, 59, 86, 20);
		ventana.getContentPane().add(cbTipo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(258, 11, 166, 180);
		ventana.getContentPane().add(scrollPane);
		
		lPokemons = new JList<>();
		scrollPane.setViewportView(lPokemons);
		ventana.setVisible(true);
		
		mPokemons = new DefaultListModel<>();
		lPokemons.setModel(mPokemons);
		
		lbImagen = new JLabel("");
		lbImagen.setIcon(new ImageIcon("C:\\PMDM\\projects\\ListViewEjemplo\\app\\src\\main\\res\\mipmap-hdpi\\ic_launcher.png"));
		lbImagen.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Imagen", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lbImagen.setBounds(159, 13, 89, 130);
		ventana.getContentPane().add(lbImagen);
		
		btEliminar = new JButton("");
		btEliminar.setActionCommand("eliminar");
		btEliminar.setIcon(new ImageIcon("C:\\Users\\Profesor\\Downloads\\open_icon_library-standard-0.11\\open_icon_library-standard\\icons\\png\\32x32\\actions\\edit-delete-2.png"));
		btEliminar.setBounds(374, 202, 50, 41);
		ventana.getContentPane().add(btEliminar);
		
		btNuevo = new JButton("");
		btNuevo.setActionCommand("nuevo");
		btNuevo.setIcon(new ImageIcon("C:\\Users\\Profesor\\Downloads\\open_icon_library-standard-0.11\\open_icon_library-standard\\icons\\png\\32x32\\actions\\contact-new-3.png"));
		btNuevo.setBounds(10, 173, 50, 41);
		ventana.getContentPane().add(btNuevo);
		
		btGuardar = new JButton("");
		btGuardar.setActionCommand("guardar");
		btGuardar.setIcon(new ImageIcon("C:\\Users\\Profesor\\Downloads\\open_icon_library-standard-0.11\\open_icon_library-standard\\icons\\png\\32x32\\actions\\document-save-5.png"));
		btGuardar.setBounds(126, 173, 50, 41);
		ventana.getContentPane().add(btGuardar);
		
		btCancelar = new JButton("");
		btCancelar.setActionCommand("cancelar");
		btCancelar.setIcon(new ImageIcon("C:\\Users\\Profesor\\Downloads\\open_icon_library-standard-0.11\\open_icon_library-standard\\icons\\png\\32x32\\actions\\dialog-cancel-5.png"));
		btCancelar.setBounds(186, 173, 50, 41);
		ventana.getContentPane().add(btCancelar);
		
		ventana.setTitle("PokemonSQL");
		ventana.setLocationRelativeTo(null);
		ventana.repaint();		
	}
}
