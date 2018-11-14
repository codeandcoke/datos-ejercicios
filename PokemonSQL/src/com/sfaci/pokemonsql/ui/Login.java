package com.sfaci.pokemonsql.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JDialog implements ActionListener, KeyListener {

	private final JPanel contentPanel = new JPanel();
	public JTextField tfUsuario;
	public JPasswordField tfContrasena;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JButton btSalir;
	public JButton btEntrar;
	private JLabel lbMensaje;
	
	private String usuario;
	private String contrasena;

	public Login() {
		setTitle("Login");
		setBounds(100, 100, 295, 184);
		getContentPane().setLayout(new BorderLayout());
	
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		lbMensaje = new JLabel();
		lbMensaje.setForeground(Color.RED);
		getContentPane().add(lbMensaje, BorderLayout.NORTH);
		
		tfUsuario = new JTextField();
		tfUsuario.setColumns(10);
		
		tfContrasena = new JPasswordField();
		tfContrasena.setColumns(10);
		
		lblNewLabel = new JLabel("Usuario");
		
		lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addGap(21)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(tfContrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(261, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfContrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addContainerGap(149, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		btEntrar = new JButton("Entrar");
		btEntrar.setActionCommand("entrar");
		buttonPane.add(btEntrar);
		
		btSalir = new JButton("Salir");
		btSalir.setActionCommand("salir");
		buttonPane.add(btSalir);
		
		tfContrasena.addKeyListener(this);
		tfUsuario.addKeyListener(this);
		
		btEntrar.addActionListener(this);
		btSalir.addActionListener(this);
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setModal(true);

	}
	
	public void mostrarDialogo() {
		setVisible(true);
	}
	
	public String getUsuario() { return usuario; }
	
	public String getContrasena() { return contrasena; }
	
	public void setMensaje(String mensaje) {
		
		lbMensaje.setText(mensaje);
	}
	
	public void limpiarContrasena() {
		tfContrasena.setText("");
		tfContrasena.requestFocus();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
			case "entrar":
				usuario = tfUsuario.getText();
				contrasena = String.valueOf(tfContrasena.getPassword());
				setVisible(false);
				break;
			case "salir":
				System.exit(0);
				break;
			default:
				break;
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			btEntrar.doClick();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}
}
