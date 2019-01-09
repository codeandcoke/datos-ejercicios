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
import com.sfaci.ejemplohibernate.beans.JEstado;
import com.sfaci.ejemplohibernate.beans.PanelArmas;
import com.sfaci.ejemplohibernate.beans.PanelPersonajes;

public class Vista extends JFrame {

	public JPanel contentPane;
	public DefaultListModel<Personaje> mPersonajes;
	public JEstado jEstado;
	public JTabbedPane tpPaneles;
	public JMenu mEditar;
	public JMenuItem miPersonajes;
	public JMenuItem miArmas;

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
		
		mEditar = new JMenu("Editar");
		menuBar.add(mEditar);
		
		miPersonajes = new JMenuItem("Personajes");
		miPersonajes.setActionCommand("PANEL_PERSONAJES");
		mEditar.add(miPersonajes);
		
		miArmas = new JMenuItem("Armas");
		miArmas.setActionCommand("PANEL_ARMAS");
		mEditar.add(miArmas);
		
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
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("New button");
		toolBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		toolBar.add(btnNewButton_2);
		
		jEstado = new JEstado();
		contentPane.add(jEstado, BorderLayout.SOUTH);
		
		tpPaneles = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tpPaneles, BorderLayout.CENTER);
		
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
