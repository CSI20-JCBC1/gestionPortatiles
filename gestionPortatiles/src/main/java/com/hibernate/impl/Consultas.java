package com.hibernate.impl;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.dal.GestionAlumnos;
import com.hibernate.dal.GestionAlumnosServicioImpl;
import com.hibernate.dal.GestionPortatiles;
import com.hibernate.dal.GestionPortatilesServicioImpl;

@Service
public class Consultas {
	
	@Autowired
	private GestionAlumnosServicioImpl gai;
	@Autowired
	private GestionPortatilesServicioImpl gpi;
	
	//Consultas de gestión de alumnos
	
	@Transactional
	public void insertarUnaMatricula(GestionAlumnos gestionAlumnos) {
		gai.insertarMatricula(gestionAlumnos);
	}
	
	@Transactional
	public void insertarListaMatriculas(Collection<GestionAlumnos> colAlumnos){
		for (GestionAlumnos gestionAlumnos : colAlumnos) {
			gai.insertarMatricula(gestionAlumnos);
		}
	}
	
	@Transactional
	public List<GestionAlumnos> buscarAlumnos(){
		return gai.buscarAlumnos();
	}
	
	@Transactional
	public GestionAlumnos buscarAlumnoPorId(Integer id){
		return gai.buscarAlumnoPorId(id);
	}
	
	
	//Consultas de gestión de ordenadores

	@Transactional
	public void insertarUnOrdenador(GestionPortatiles gestionPortatiles) {
		gpi.insertarPortatil(gestionPortatiles);
	}

	@Transactional
	public void insertarListaOrdenadores(Collection<GestionPortatiles> colPortatiles) {
		for(GestionPortatiles gestionOrdenadores : colPortatiles) {
			gpi.insertarPortatil(gestionOrdenadores);
		}
	}

	@Transactional
	public List<GestionPortatiles> buscarOrdenadores() {
		return gpi.buscarPortatiles();
	}

	
}
