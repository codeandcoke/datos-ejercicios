package com.sfaci.login.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public JTextField tfUsuario;
	public JTextField tfContrasena;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;

	public Login() {
		setTitle("Login");
		setBounds(100, 100, 275, 164);
		getContentPane().setLayout(new BorderLayout());
	
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		tfUsuario = new JTextField();
		tfUsuario.setColumns(10);
		
		tfContrasena = new JTextField();
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
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btEntrar = new JButton("Entrar");
				btEntrar.setActionCommand("OK");
				buttonPane.add(btEntrar);
				getRootPane().setDefaultButton(btEntrar);
			}
			{
				JButton btSalir = new JButton("Salir");
				btSalir.setActionCommand("Cancel");
				buttonPane.add(btSalir);
			}
		}
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setModal(true);
		setVisible(true);
	}
}
