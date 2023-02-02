package com.hibernate.dal;

import java.util.List;

import com.hibernate.dao.GestionPortatilesDTO;

public interface GestionPortatilesServicio {
	
	public void insertarPortatil(GestionPortatiles gestionPortatiles);

	public List<GestionPortatiles> buscarPortatiles();
	
	//public GestionAlumnos buscarAlumnoPorPortatilorId(Integer id) ;
	
	public GestionPortatiles buscarOrdenadorporIdAlum(Integer idAlum);


}
