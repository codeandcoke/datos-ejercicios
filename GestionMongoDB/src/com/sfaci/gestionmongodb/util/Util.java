package com.sfaci.gestionmongodb.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dam on 10/02/17.
 */
public class Util {

    public static String formatFecha(Date fecha) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        return sdf.format(fecha);

    }
}
