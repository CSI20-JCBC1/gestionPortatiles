package com.hibernate.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernate.dal.GestionAlumnos;
import com.hibernate.dal.GestionPortatiles;
import com.hibernate.dao.ADaoServicio;
import com.hibernate.dao.ADaoServicioImpl;
import com.hibernate.dao.ADtoServicio;
import com.hibernate.dao.ADtoServicioImpl;
import com.hibernate.dao.GestionAlumnosDTO;
import com.hibernate.dao.GestionPortatilesDTO;
import com.hibernate.impl.Consultas;

public class Controlador {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("contexto.xml");
		Consultas consulta = (Consultas) context.getBean(Consultas.class);

		Integer opcion1;
		ADtoServicio aDto = new ADtoServicioImpl();
		ADaoServicio aDao = new ADaoServicioImpl();

		do {
			System.out.println("Escriba el valor a uno de los asignados:");
			System.out.println("");
			System.out.println("1.-Matricula alumno. ");
			System.out.println("2.-Baja de un alumno. ");
			System.out.println("3.-Alta de portátil. ");
			System.out.println(
					"4.-Consulta portátil asignado a un alumno (se conoce el número de alumno se busca el portátil) ");
			System.out.println(
					"5.-Consulta alumno asignado a un portátil (se conoce el identificador del portátil se busca el alumno) ");
			System.out.println(
					"6.-Ver todos los alumnos con su asignación de portátil");
			System.out.println("7.-Salir. ");

			System.out.println();
			System.out.print("Introduzca una opcion: ");
			Scanner scan = new Scanner(System.in);
			opcion1 = scan.nextInt();
			Calendar fecha = Calendar.getInstance();

			// DTO para el pago repostaje
			GestionAlumnosDTO DTO;
			GestionAlumnos gestionAlumnos=new GestionAlumnos();

			// DTO para el control camiones
			GestionPortatilesDTO DTOPortatiles;
			GestionPortatiles gestionPrt = new GestionPortatiles();

			UUID uuid;
			String mduuid;
			List<GestionPortatiles> listaP = consulta.buscarOrdenadores();
			String nombre, apellidos, telefono;
			Integer idPortatil;

			switch (opcion1) {
			case 1:
				//Creacion de un alumno a mano insertando sus datos a mano
				
				//mduuid aleatorio
				uuid = UUID.randomUUID();
				mduuid = uuid.toString();
				System.out.println("Ha escogido la opcion de matricular un alumno, tenga en cuenta que deberá existir al menos un portatil para poder matricular al alumno.");
				
				System.out.print("Inserta el nombre del alumno: ");
				nombre=scan.next();
				System.out.print("\nInserta los apellidos del alumno: ");
				apellidos=scan.next();
				System.out.print("\nInserta el telefono del alumno: ");
				telefono=scan.next();
				
				//Obtenemos el id del portatil que quermos asignar a este alumno y restamos 1 para que el indice coincida con los indices de la lista
				System.out.print("\nInserta el id del portatil: ");
				idPortatil=scan.nextInt()-1;

				DTO = aDto.AGestionAlumnosDTO(mduuid,fecha, nombre, apellidos, telefono, listaP.get(idPortatil));
				gestionAlumnos = aDao.GestionAlumnosDTOADAO(DTO);
				consulta.insertarUnaMatricula(gestionAlumnos);	

				break;
			case 2:
				//Borrar un alumno por su id
				System.out.println("Ha escogido la opcion de dar de baja a un alumno: ");
		        System.out.println("Indique el id del alumno que quiere eliminar");
		        Integer id = scan.nextInt();
		        consulta.eliminarUnAlumno(id);

				break;
			case 3:
				//Creación de un portatil en la base de datos insertando sus campos a mano
				uuid = UUID.randomUUID();
				mduuid = uuid.toString();
				System.out.println("Ha escogido la opción de dar de alta un portátil");
				System.out.print("Introduzca el modelo del portatil: ");
				String modelo=scan.next();
				System.out.print("Introduzca la marca del portatil: ");
				String marca = scan.next();
				DTOPortatiles = aDto.AGestionPortatilesDTO(mduuid, fecha, modelo, marca);
				GestionPortatiles portatil = aDao.GestionPortatilesDTOADAO(DTOPortatiles);
				consulta.insertarUnOrdenador(portatil);
				
				break;
			case 4:
				
				//Busqueda de un portatil introduciendo el id del alumno
				System.out.println("Ha escogido la opcion de consulta portátil asignado a un alumno por id de alumno");
				System.out.println("Introduce el id del alumno para buscar su portatil.");
				Integer idAlm = scan.nextInt();
				gestionPrt = consulta.buscarOrdenadorPorIdAlumno(idAlm);
				System.out.println("El portatil asignado a este alumno es: " + gestionPrt.getMarca());
				
				
				break;
			case 5:
				//Busueda de un alumno introduciendo el id del portatil
				System.out.println("Ha escogido la opcion de consulta alumno asignado a un portatil por id de portatil");
				System.out.println("Introduce el id del portatil para buscar su alumno.");
				Integer idPort=scan.nextInt();
				gestionAlumnos = consulta.buscarAlumnoPorIdPortatil(idPort);
				System.out.println("El alumno asignado a este portatil es: " + gestionAlumnos.getNombre()+" "+ gestionAlumnos.getApellidos());
				
				break;
			case 6:
				//Listado de todos los alumnos con su portatil asignado
				List<GestionAlumnos>listaAlumnosPrt= consulta.listaAlumnos();
				for(GestionAlumnos alumno : listaAlumnosPrt) {
					System.out.println("Alumno: " + alumno.getNombre() + " " + alumno.getApellidos() + " Portatil: " + alumno.getPortatiles().getMarca()+ " / " +alumno.getPortatiles().getModelo());
				}
				break;
			case 7:
				//Salida de la aplicacion
				System.out.println("Saliendo de la aplicacion.");
				break;
			default:

			}

		} while (opcion1 != 7);
	}

}
