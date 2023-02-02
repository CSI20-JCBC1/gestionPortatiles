package com.hibernate.dal;

import java.util.List;

import com.hibernate.dao.GestionAlumnosDTO;

public interface GestionAlumnosServicio {

	public void insertarMatricula(GestionAlumnos gestionAlumnos);

	public List<GestionAlumnos> buscarAlumnos();

	public GestionAlumnos buscarAlumnoPorId(Integer id);

	public void eliminarAlumno(Integer id);
	
	public GestionAlumnos buscarAlumnoPorIdPortatil(Integer idPortatil);
	
	public List<GestionAlumnos> buscarTodos();
}
