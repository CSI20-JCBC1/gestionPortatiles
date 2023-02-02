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
import com.hibernate.dao.GestionPortatilesDTO;

@Service
public class Consultas {
	
	@Autowired
	private GestionAlumnosServicioImpl gai;
	@Autowired
	private GestionPortatilesServicioImpl gpi;
	
	//Consultas de gestión de alumnos llamsndo a GestionAlumnosServicioImpl
	
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
	
	@Transactional
    public void eliminarUnAlumno(Integer id) {
        gai.eliminarAlumno(id);
    }
	
	public GestionAlumnos buscarAlumnoPorIdPortatil(Integer idPort) {
		return gai.buscarAlumnoPorIdPortatil(idPort);
	}
	
	public List<GestionAlumnos> listaAlumnos(){
		return gai.buscarTodos();
	}
	
	
	//Consultas de gestión de portatiles llamando a GestionPortatilesServicioImpl

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

	
	public GestionPortatiles buscarOrdenadorPorIdAlumno(Integer idAlum) {
        return gpi.buscarOrdenadorporIdAlum(idAlum);
    }
	
	
}
