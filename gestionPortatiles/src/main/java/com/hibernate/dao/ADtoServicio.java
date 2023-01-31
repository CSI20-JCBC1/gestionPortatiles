package com.hibernate.dao;

import java.util.Calendar;

import com.hibernate.dal.GestionAlumnos;
import com.hibernate.dal.GestionPortatiles;

public interface ADtoServicio {
	
	public GestionAlumnosDTO AGestionAlumnosDTO(String md_uuid, Calendar md_date, String nombre_alumno,
			String apellidos_alumno, String num_telefono, GestionPortatiles portatiles);
	
	public GestionAlumnosDTO AGestionAlumnosDTO(String md_uuid, Calendar md_date, String nombre_alumno,
			String apellidos_alumno, String num_telefono);
	
	public GestionPortatilesDTO AGestionPortatilesDTO(String md_uuid, Calendar md_date, String modelo, String marca,
			GestionAlumnos alumno);

}
