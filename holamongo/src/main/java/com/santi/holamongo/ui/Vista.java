package com.santi.holamongo.ui;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.github.lgooddatepicker.components.DatePicker;
import com.santi.holamongo.beans.JBotonesCrud;
import com.santi.holamongo.beans.PanelBusqueda;
import com.santi.holamongo.domain.Coche;
import com.santi.holamongo.domain.Propietario;
import com.santi.holamongo.util.NumeroUtil;

public class Vista extends JFrame implements FocusListener {

	private JPanel contentPane;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JTextField tfModelo;
	public JTextField tfMarca;
	public JTextField tfPrecio;
	public JLabel lblPrecio;
	public JLabel lblFechaDeCompra;
	public DatePicker dpFechaCompra;
	public JLabel lblTalleresAfuera;
	public JBotonesCrud botonesCrud;
	public PanelBusqueda<Coche> panelBusqueda;
	public JComboBox<Propietario> cbPropietarios;

	/**
	 * Create the frame.
	 */
	public Vista() {
		setTitle("HolaMongo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Marca");
		lblNewLabel.setBounds(10, 52, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Modelo");
		lblNewLabel_1.setBounds(10, 77, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfModelo = new JTextField();
		tfModelo.setBounds(118, 74, 142, 20);
		contentPane.add(tfModelo);
		tfModelo.setColumns(10);
		
		tfMarca = new JTextField();
		tfMarca.setBounds(118, 49, 142, 20);
		contentPane.add(tfMarca);
		tfMarca.setColumns(10);
		
		tfPrecio = new JTextField();
		tfPrecio.setBounds(118, 101, 75, 20);
		contentPane.add(tfPrecio);
		tfPrecio.setColumns(10);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 104, 46, 14);
		contentPane.add(lblPrecio);
		
		lblFechaDeCompra = new JLabel("Fecha de Compra");
		lblFechaDeCompra.setBounds(10, 134, 99, 14);
		contentPane.add(lblFechaDeCompra);
		
		dpFechaCompra = new DatePicker();
		dpFechaCompra.setBounds(118, 132, 194, 25);
		contentPane.add(dpFechaCompra);
		
		lblTalleresAfuera = new JLabel("Talleres Afuera");
		lblTalleresAfuera.setFont(new Font("Sitka Text", Font.BOLD, 20));
		lblTalleresAfuera.setBounds(117, 11, 175, 27);
		contentPane.add(lblTalleresAfuera);
		
		botonesCrud = new JBotonesCrud();
		botonesCrud.setBounds(10, 168, 185, 108);
		contentPane.add(botonesCrud);
		
		panelBusqueda = new PanelBusqueda<>();
		panelBusqueda.setBounds(342, 52, 175, 188);
		contentPane.add(panelBusqueda);
		
		cbPropietarios = new JComboBox();
		cbPropietarios.setBounds(205, 168, 107, 20);
		contentPane.add(cbPropietarios);
		
		inicializar();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void inicializar() {
		tfPrecio.addFocusListener(this);
	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {
		String precio = tfPrecio.getText();
		if (precio.equals(""))
			return;
		
		precio = precio.replace("€", "").replace(",", ".").trim();
		tfPrecio.setText(NumeroUtil.formatMoneda(Float.valueOf(precio)));
		
	}
}
