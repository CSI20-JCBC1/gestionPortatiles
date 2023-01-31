package com.hibernate.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class GestionPortatilesServicioImpl implements GestionPortatilesServicio{

	@PersistenceContext
	private EntityManager emPort;
	
	@Override
	public void insertarPortatil(GestionPortatiles gestionPortatiles) {
		emPort.persist(gestionPortatiles);
		emPort.clear();
		emPort.close();
	}

	@Override
	public List<GestionPortatiles> buscarPortatiles() {
		return emPort.createQuery("SELECT alum FROM GestionAlumnos alum").getResultList();
	}

}
