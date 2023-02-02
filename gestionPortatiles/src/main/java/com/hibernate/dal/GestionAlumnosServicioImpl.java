package com.hibernate.dal;

import java.util.ArrayList;
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
		// Insercion de un alumno dentro de la base de datos
		try {
			em.persist(gestionAlumnos);
			em.clear();
			em.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public List<GestionAlumnos> buscarAlumnos() {
		try {
			// Ejecución de un select, seleccionamos todos los alumnos dentro de la bse de
			// datos y devolvemos una lista
			return em.createQuery("SELECT alum FROM GestionAlumnos alum").getResultList();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public GestionAlumnos buscarAlumnoPorId(Integer id) {
		try {
			//Seleccionamos un alumno por su id indicando que en la query idAlm corresponde al id que pasamos como parámetro
			String jpql = "SELECT alum FROM GestionAlumnos alum WHERE alum.id_alumno = :idAlm";
			Query query = em.createQuery(jpql);
			query.setParameter("idAlm", id);
			//Creamos una lista donde recogemos los datos del select y guardamos esos datos en un objeto del tipo alumno el cual vamos a devolver con el return
			GestionAlumnos alumno = new GestionAlumnos();
			List<GestionAlumnos> alumnoL = query.getResultList();
			alumno.setMd_uuid(alumnoL.get(0).getMd_uuid());
			alumno.setMd_date(alumnoL.get(0).getMd_date());
			alumno.setNombre(alumnoL.get(0).getNombre());
			alumno.setApellidos(alumnoL.get(0).getApellidos());
			alumno.setNum_telefono(alumnoL.get(0).getNum_telefono());
			return alumno;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

	@Override
	public void eliminarAlumno(Integer id) {
		try {
			//Borramos un alumno segun el id introducido con id_al hacemos lo mismo que he comentadon en el método anterior
			String jpql = "DELETE FROM GestionAlumnos ga WHERE ga.id_alumno = :id_al";
			Query query = em.createQuery(jpql);
			query.setParameter("id_al", id);
			int numeroEliminados = query.executeUpdate();
			System.out.println("Alumno eliminado con exito ");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public GestionAlumnos buscarAlumnoPorIdPortatil(Integer idPortatil) {
		try {
			//Seleccionamos un portatil dentro de la base de datos a través de su id 
			String jpql = "SELECT portatil FROM GestionPortatiles portatil WHERE portatil.id_ordenador = :idPortatil";
			Query query = em.createQuery(jpql);
			query.setParameter("idPortatil", idPortatil);
			//Recogemos los datos de la query dentro de una lista
			ArrayList<GestionPortatiles> listaPortatiles = (ArrayList<GestionPortatiles>) query.getResultList();
			//Obtenemos el alumno resultante de la lista de los portatil con el método getAlumno y creamos un objeto alumno y lo devpolvemos en el return
			GestionAlumnos alumnos = listaPortatiles.get(0).getAlumno();
			return alumnos;

		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<GestionAlumnos> buscarTodos() {
		try {
			//Buscamos todos los alumnos y los devolvemos en el return en forma de lista
			return em.createQuery("SELECT alumnos FROM GestionAlumnos alumnos").getResultList();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}
}