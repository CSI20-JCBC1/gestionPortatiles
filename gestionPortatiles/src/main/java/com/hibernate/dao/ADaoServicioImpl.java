package com.hibernate.dao;

import com.hibernate.dal.GestionAlumnos;
import com.hibernate.dal.GestionPortatiles;

public class ADaoServicioImpl implements ADaoServicio {

	
	//Paso de AlumnoDTO a Alumno
	@Override
	public GestionAlumnos GestionAlumnosDTOADAO(GestionAlumnosDTO gestionAlumnosDTO) {
		GestionAlumnos gestionAlumnos = new GestionAlumnos();
		if(gestionAlumnosDTO != null) {
			gestionAlumnos.setMd_uuid(gestionAlumnosDTO.getMd_uuid());
			gestionAlumnos.setMd_date(gestionAlumnosDTO.getMd_date());
			gestionAlumnos.setNombre(gestionAlumnosDTO.getNombre());
			gestionAlumnos.setApellidos(gestionAlumnosDTO.getApellidos());
			gestionAlumnos.setNum_telefono(gestionAlumnosDTO.getNum_telefono());
			gestionAlumnos.setPortatiles(gestionAlumnosDTO.getPortatiles());
		}
		return gestionAlumnos;
	}

	//Paso de PortatilDTO a Portatil
	@Override
	public GestionPortatiles GestionPortatilesDTOADAO(GestionPortatilesDTO gestionPortatilesDTO) {
		GestionPortatiles gestionPortatiles = new GestionPortatiles();
		if(gestionPortatilesDTO != null) {
			gestionPortatiles.setMd_uuid(gestionPortatilesDTO.getMd_uuid());
			gestionPortatiles.setMd_date(gestionPortatilesDTO.getMd_date());
			gestionPortatiles.setMarca(gestionPortatilesDTO.getMarca());;
			gestionPortatiles.setModelo(gestionPortatilesDTO.getModelo());
			gestionPortatiles.setAlumno(gestionPortatilesDTO.getAlumno());
		}
		return gestionPortatiles;
	}

}
