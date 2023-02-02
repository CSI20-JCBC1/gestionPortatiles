package com.hibernate.dao;

import java.util.Calendar;

import com.hibernate.dal.GestionAlumnos;
import com.hibernate.dal.GestionPortatiles;

public class ADtoServicioImpl implements ADtoServicio {

	@Override
	public GestionAlumnosDTO AGestionAlumnosDTO(String md_uuid, Calendar md_date, String nombre_alumno,
			String apellidos_alumno, String num_telefono, GestionPortatiles portatiles) {
		GestionAlumnosDTO DTO = new GestionAlumnosDTO(md_uuid, md_date, nombre_alumno, apellidos_alumno, num_telefono,
				portatiles);

		return DTO;
	}

	@Override
	public GestionPortatilesDTO AGestionPortatilesDTO(String md_uuid, Calendar md_date, String modelo, String marca) {
		GestionPortatilesDTO DTO = new GestionPortatilesDTO(md_uuid, md_date, modelo, marca);

		return DTO;
	}

}
