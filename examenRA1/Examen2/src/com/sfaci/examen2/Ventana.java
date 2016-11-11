package com.sfaci.examen2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by dam on 11/11/16.
 */
public class Ventana implements ActionListener {
    private JButton btCargar;
    private JPanel panel1;
    private JList lPersonajes;

    private DefaultListModel dlmPersonajes;

    private ArrayList<Personaje> personajes;

    public Ventana() {

        btCargar.addActionListener(this);

        personajes = new ArrayList<>();
        dlmPersonajes = new DefaultListModel();
        lPersonajes.setModel(dlmPersonajes);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        leerFicheroXML();
    }

    public void leerFicheroXML() {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document documento = null;

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            documento = builder.parse(new File("personajes.xml"));

            Personaje personaje = null;
            // Recorre cada uno de los nodos 'Persona'
            NodeList personas = documento.getElementsByTagName("enemigo");
            for (int i = 0; i < personas.getLength(); i++) {
                Node persona = personas.item(i);
                Element elemento = (Element) persona;

                personaje = new Personaje();

                personaje.setNombre(elemento.getElementsByTagName("nombre").item(0).
                        getChildNodes().item(0).getNodeValue());

                personaje.setVida(Integer.parseInt(elemento.getElementsByTagName("vida").item(0).
                        getChildNodes().item(0).getNodeValue()));

                personaje.setAtaque(Integer.parseInt(elemento.getElementsByTagName("ataque").item(0).
                        getChildNodes().item(0).getNodeValue()));

                SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");

                personaje.setFechaNacimiento(sdf.parse(elemento.getElementsByTagName("fecha_nacimiento").item(0).
                        getChildNodes().item(0).getNodeValue()));

                personajes.add(personaje);
            }

            for (Personaje unPersonaje : personajes) {
                dlmPersonajes.addElement(unPersonaje);
            }


        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException saxe) {
            saxe.printStackTrace();
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
