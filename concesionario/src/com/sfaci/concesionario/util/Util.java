package com.sfaci.concesionario.util;

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Métodos de utilidad
 *
 * @author Santiago Faci
 * @version curso 2016-2017
 */
public class Util {

    private static final String PATRON_FECHA = "dd/mm/yyyy";
    private static final String PATRON_POTENCIA = "#,##0.00 cv";

    public static Date parseFecha(String fecha) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(PATRON_FECHA);
        return sdf.parse(fecha);
    }

    public static String formatFecha(Date fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat(PATRON_FECHA);
        return sdf.format(fecha);
    }

    public static String formatPotencia(float potencia) {
        DecimalFormat df = new DecimalFormat(PATRON_POTENCIA);
        return df.format(potencia);
    }

    public static float parsePotencia(String potencia) throws ParseException {
        DecimalFormat df = new DecimalFormat(PATRON_POTENCIA);
        return df.parse(potencia).floatValue();

    }

    public static void mensajeError(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje,
                titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static void mensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje,
                "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void mensajeInformacion(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje,
                titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static int mensajeConfirmacion(String mensaje, String titulo) {
        return JOptionPane.showConfirmDialog(null, mensaje,
                titulo, JOptionPane.YES_NO_OPTION);
    }

}
