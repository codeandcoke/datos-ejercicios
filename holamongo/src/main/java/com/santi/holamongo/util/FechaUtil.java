package com.santi.holamongo.util;

import java.time.LocalDate;
import java.util.Date;

public class FechaUtil {
	
	public static Date toDate(LocalDate fecha) {
		return new Date(java.sql.Date.valueOf(fecha).getTime());
	}
	
	public static LocalDate toLocalDate(Date fecha) {
		return new java.sql.Date(fecha.getTime()).toLocalDate();
	}
}
