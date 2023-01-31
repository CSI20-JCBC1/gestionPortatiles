package com.hibernate.dao;

import com.hibernate.dal.GestionAlumnos;
import com.hibernate.dal.GestionPortatiles;

public interface ADaoServicio {
	
	public GestionAlumnos GestionAlumnosDTOADAO(GestionAlumnosDTO gestionAlumnosDTO);

	public GestionPortatiles GestionPortatilesDTOADAO(GestionPortatilesDTO gestionPortatilesDTO);
	
	public GestionAlumnos GestionAlumnosDTOADAO2(GestionAlumnosDTO gestionAlumnosDTO);

}
