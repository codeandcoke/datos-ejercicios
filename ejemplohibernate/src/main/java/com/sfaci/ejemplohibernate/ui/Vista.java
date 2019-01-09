package com.sfaci.ejemplohibernate.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import com.sfaci.ejemplohibernate.base.Arma;
import com.sfaci.ejemplohibernate.base.Personaje;

public class Vista extends JFrame {

	public JPanel contentPane;
	public DefaultListModel<Personaje> mPersonajes;
	public JLabel lblNewLabel_1;
	public JTextField tfNombre;
	public JTextField tfDescripcion;
	public JTextField tfVida;
	public JTextField tfAtaque;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_3;
	public JLabel lblNewLabel_4;
	public JComboBox<Arma> cbArmas;
	public JButton btAnadirArma;
	public JScrollPane scrollPane;
	public JList<Arma> lArmas;
	public JButton btNuevo;
	public JButton btModificar;
	public JButton btGuardar;
	public JButton btCancelar;
	public JScrollPane scrollPane_1;
	public JList<Personaje> lPersonajes;
	public JButton btEliminar;
	public JTextField btBuscar;

	public Vista() {
		setTitle("CRUD Hibernate");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 368);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Opciones");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("Ayuda");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnNewMenu_2.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("New label");
		contentPane.add(lblNewLabel, BorderLayout.SOUTH);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("New button");
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		toolBar.add(btnNewButton_2);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Armas", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Personajes", null, panel_1, null);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);
		
		lblNewLabel_1 = new JLabel("Nombre");
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.WEST, panel_1);
		panel_1.add(lblNewLabel_1);
		
		tfNombre = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 3, SpringLayout.NORTH, tfNombre);
		sl_panel_1.putConstraint(SpringLayout.NORTH, tfNombre, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, tfNombre, 64, SpringLayout.WEST, panel_1);
		panel_1.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfDescripcion = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, tfDescripcion, 6, SpringLayout.SOUTH, tfNombre);
		sl_panel_1.putConstraint(SpringLayout.EAST, tfDescripcion, 0, SpringLayout.EAST, tfNombre);
		panel_1.add(tfDescripcion);
		tfDescripcion.setColumns(10);
		
		tfVida = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, tfVida, 6, SpringLayout.SOUTH, tfDescripcion);
		sl_panel_1.putConstraint(SpringLayout.EAST, tfVida, 0, SpringLayout.EAST, tfNombre);
		panel_1.add(tfVida);
		tfVida.setColumns(10);
		
		tfAtaque = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, tfAtaque, 6, SpringLayout.SOUTH, tfVida);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, tfAtaque, 26, SpringLayout.SOUTH, tfVida);
		sl_panel_1.putConstraint(SpringLayout.EAST, tfAtaque, 0, SpringLayout.EAST, tfNombre);
		panel_1.add(tfAtaque);
		tfAtaque.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Descripci\u00F3n");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 13, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0, SpringLayout.WEST, lblNewLabel_1);
		panel_1.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Vida");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 12, SpringLayout.SOUTH, lblNewLabel_2);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0, SpringLayout.WEST, lblNewLabel_1);
		panel_1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Ataque");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 11, SpringLayout.SOUTH, lblNewLabel_3);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0, SpringLayout.WEST, lblNewLabel_1);
		panel_1.add(lblNewLabel_4);
		
		cbArmas = new JComboBox<Arma>();
		sl_panel_1.putConstraint(SpringLayout.NORTH, cbArmas, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, cbArmas, 6, SpringLayout.EAST, tfNombre);
		sl_panel_1.putConstraint(SpringLayout.EAST, cbArmas, 92, SpringLayout.EAST, tfNombre);
		panel_1.add(cbArmas);
		
		btAnadirArma = new JButton("+");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btAnadirArma, -1, SpringLayout.NORTH, tfNombre);
		sl_panel_1.putConstraint(SpringLayout.WEST, btAnadirArma, 10, SpringLayout.EAST, cbArmas);
		panel_1.add(btAnadirArma);
		
		btNuevo = new JButton("Nuevo");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btNuevo, 118, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, btNuevo, 0, SpringLayout.WEST, lblNewLabel_1);
		btNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		scrollPane = new JScrollPane();
		sl_panel_1.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, btAnadirArma);
		sl_panel_1.putConstraint(SpringLayout.WEST, scrollPane, 6, SpringLayout.EAST, tfDescripcion);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, scrollPane, 76, SpringLayout.SOUTH, btAnadirArma);
		sl_panel_1.putConstraint(SpringLayout.EAST, scrollPane, 292, SpringLayout.WEST, panel_1);
		panel_1.add(scrollPane);
		
		lArmas = new JList<Arma>();
		scrollPane.setViewportView(lArmas);
		panel_1.add(btNuevo);
		
		btModificar = new JButton("Modificar");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btModificar, 118, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, btModificar, 6, SpringLayout.EAST, btNuevo);
		panel_1.add(btModificar);
		
		btGuardar = new JButton("Guardar");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btGuardar, 6, SpringLayout.SOUTH, btNuevo);
		sl_panel_1.putConstraint(SpringLayout.EAST, btNuevo, 0, SpringLayout.EAST, btGuardar);
		sl_panel_1.putConstraint(SpringLayout.WEST, btGuardar, 0, SpringLayout.WEST, lblNewLabel_1);
		panel_1.add(btGuardar);
		
		btCancelar = new JButton("Cancelar");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btCancelar, 6, SpringLayout.SOUTH, btModificar);
		sl_panel_1.putConstraint(SpringLayout.WEST, btCancelar, 0, SpringLayout.WEST, btModificar);
		sl_panel_1.putConstraint(SpringLayout.EAST, btCancelar, 0, SpringLayout.EAST, btModificar);
		panel_1.add(btCancelar);
		
		scrollPane_1 = new JScrollPane();
		sl_panel_1.putConstraint(SpringLayout.NORTH, scrollPane_1, 13, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, scrollPane_1, 6, SpringLayout.EAST, btAnadirArma);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, scrollPane_1, 185, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, scrollPane_1, 117, SpringLayout.EAST, btAnadirArma);
		panel_1.add(scrollPane_1);
		
		lPersonajes = new JList<Personaje>();
		scrollPane_1.setViewportView(lPersonajes);
		
		btEliminar = new JButton("Eliminar");
		sl_panel_1.putConstraint(SpringLayout.NORTH, btEliminar, 6, SpringLayout.SOUTH, btGuardar);
		sl_panel_1.putConstraint(SpringLayout.WEST, btEliminar, 0, SpringLayout.WEST, lblNewLabel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btEliminar, -218, SpringLayout.WEST, scrollPane_1);
		panel_1.add(btEliminar);
		
		btBuscar = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.NORTH, btBuscar, 6, SpringLayout.SOUTH, scrollPane_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, btBuscar, 0, SpringLayout.WEST, scrollPane_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, btBuscar, 0, SpringLayout.EAST, scrollPane_1);
		panel_1.add(btBuscar);
		btBuscar.setColumns(10);
		
		mPersonajes = new DefaultListModel<>();
		
		try {
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (Exception ex) {}
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
