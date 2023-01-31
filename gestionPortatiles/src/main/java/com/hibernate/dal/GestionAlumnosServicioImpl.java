package com.hibernate.dal;

import java.util.List;

import javax.persistence.*;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hibernate.dao.GestionAlumnosDTO;

@Repository
public class GestionAlumnosServicioImpl implements GestionAlumnosServicio {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void insertarMatricula(GestionAlumnos gestionAlumnos) {
		em.persist(gestionAlumnos);
		em.clear();
		em.close();
		
	}

	@Override
	public List<GestionAlumnos> buscarAlumnos() {
		return em.createQuery("SELECT alum FROM GestionAlumnos alum").getResultList();
	}

	@Override
	public  GestionAlumnos buscarAlumnoPorId(Integer id) {
//		  String jpql = "SELECT alum FROM GestionAlumnos alum WHERE alum.id_alumno = :1";
//	        Query query = em.createQuery(jpql);
//	        query.setParameter(1, id);
//	        return query.getResultList();
		String query = "SELECT a FROM GestionAlumnos a WHERE a.id_alumno = :alumnoID";
    	
		// Issue the query and get a matching object
		TypedQuery<GestionAlumnos> typedQuery = em.createQuery(query, GestionAlumnos.class);
		typedQuery.setParameter("alumnoID", id);

		GestionAlumnos alumno = new GestionAlumnos();
		    	
		try {
			// Get matching the object and output
		    alumno = typedQuery.getSingleResult();	
		}
		    	
		catch(NoResultException e) {
			e.printStackTrace();
		}
		    	
		finally {
			// Close EntityManager
			// entityManager.flush();
		    // entityManager.clear();
		    em.close();
		}
		
		return alumno;
	}

}
