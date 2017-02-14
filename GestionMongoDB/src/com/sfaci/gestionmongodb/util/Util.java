package com.sfaci.gestionmongodb.util;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.sfaci.gestionmongodb.util.Constantes.FORMATO_FECHA;

/**
 * Created by dam on 10/02/17.
 */
public class Util {

    public static String formatFecha(Date fecha) {

        if (fecha == null)
            return "";

        SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_FECHA);
        return sdf.format(fecha);

    }

    public static Date parseFecha(String fecha) throws ParseException {

        if (fecha.equals(""))
            return null;

        SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_FECHA);
        return sdf.parse(fecha);
    }

    public static void mensajeError(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
    }
}
