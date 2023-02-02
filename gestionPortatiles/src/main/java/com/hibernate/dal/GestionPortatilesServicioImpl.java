package com.hibernate.dal;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hibernate.dao.GestionPortatilesDTO;

@Repository
public class GestionPortatilesServicioImpl implements GestionPortatilesServicio{

	@PersistenceContext
	private EntityManager emPort;
	
	@Override
	public void insertarPortatil(GestionPortatiles gestionPortatiles) {
		//Insercion de un portatil en la base de datos
		emPort.persist(gestionPortatiles);
		emPort.clear();
		emPort.close();
	}

	@Override
	public List<GestionPortatiles> buscarPortatiles() {
		try {
			//Seleccionamos todos los portatiles y los devolvemos en el return en forma de lista
		return emPort.createQuery("SELECT port FROM GestionPortatiles port").getResultList();
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	
	@Override
    public GestionPortatiles buscarOrdenadorporIdAlum(Integer idAlum) {
		try {
        //Seleccionamos los alumnos por el id que pasamos como parametro
		String jpql = "SELECT alum FROM GestionAlumnos alum WHERE alum.id_alumno = :idAlm";
		Query query = emPort.createQuery(jpql);
		query.setParameter("idAlm", idAlum);
		//Creamos una lista de alumnos con los valores obtenidos de la consulta
        ArrayList<GestionAlumnos> listaAlumnos = (ArrayList<GestionAlumnos>) query.getResultList();
        //Obtenemos el portatil perteneciente a ese alumno con el método getPortatiles y lo devolvemos en el return 
        GestionPortatiles portatiles = listaAlumnos.get(0).getPortatiles();
        return portatiles;
		}catch(Exception e) {
			System.out.println(e);
			
		}
		return null;
        
    }
	
	

}
