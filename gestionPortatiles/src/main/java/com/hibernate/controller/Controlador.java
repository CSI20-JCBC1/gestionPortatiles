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
					"4.-Consulta portátil asignado a un alumno (se conoce el número de alumno se busca el portátil). ");
			System.out.println(
					"5.-Consulta alumno asignado a un portátil (se conoce el identificador del portátil se busca el alumno). ");
			System.out.println(
					"6.-Consulta alumno asignado a un portátil (se conoce el identificador del portátil se busca el alumno). ");
			System.out.println("7.-Salir. ");

			System.out.println();
			System.out.print("Introduzca una opcion: ");
			Scanner scan = new Scanner(System.in);
			opcion1 = scan.nextInt();
			Calendar fecha = Calendar.getInstance();

			// DTO para el pago repostaje
			GestionAlumnosDTO DTO;
			GestionAlumnos gestionAlumnos;

			// DTO para el control camiones
			GestionPortatilesDTO DTOPortatiles;
			GestionPortatiles gestionPrt = new GestionPortatiles();

			UUID uuid;
			String mduuid;

			switch (opcion1) {
			case 1:
				uuid = UUID.randomUUID();
				mduuid = uuid.toString();
				System.out.println("Ha escogido la opcion de matricular un alumno");
				DTO = aDto.AGestionAlumnosDTO(mduuid, fecha, "Juan Carlos", "Bada Carbo", "629223094");
				gestionAlumnos = aDao.GestionAlumnosDTOADAO(DTO);
				consulta.insertarUnaMatricula(gestionAlumnos);
				break;
			case 2:
				/*
				 * System.out.println("Has escogido la opción de repostaje con pago con factura"
				 * ); DTO = aDto.APagoRepostajeFacturaDTO("rvhfyjkeodkkuhgu3", fecha, 12,
				 * "7789432Q", "9008BTX", fecha); pagosRepostaje =
				 * aDao.PagoRepostajeDTOADAO(DTO); consulta.insertarUnRepostaje(pagosRepostaje);
				 */
				break;
			case 3:
				uuid = UUID.randomUUID();
				mduuid = uuid.toString();
				System.out.println("Ha escogido la opción de dar de alta un portátil");
				System.out.print("Introduzca el id del alumno al que quiere añadir el portatil: ");
				Integer idAlmn=scan.nextInt();
				GestionAlumnos alumno=consulta.buscarAlumnoPorId(idAlmn);
				DTOPortatiles = aDto.AGestionPortatilesDTO(mduuid, fecha, "GTK-656", "DELL", alumno);
				GestionPortatiles portatil=aDao.GestionPortatilesDTOADAO(DTOPortatiles);
				consulta.insertarUnOrdenador(portatil);
				
				

				break;
			case 4:
				/*
				 * List<PagosRepostaje> repostajes = new ArrayList<PagosRepostaje>(); repostajes
				 * = consulta.buscarTodos(); int suma=0; for(PagosRepostaje pagos: repostajes) {
				 * suma+=pagos.getImporte(); }
				 * System.out.println("La suma de los repostajes es: "+suma+ " euros");
				 */
				break;
			case 5:
				/*
				 * System.out.println("Has escogido la opción de llenar el depósito");
				 * DTOCamiones = aDto.AControlCamionesDTO("rvhfyjkeodkkuhgu3", fecha, 30,
				 * "Gasolina95", 58 ); controlCamiones =
				 * aDao.ControlCamionesDTOADAO(DTOCamiones);
				 * consulta.insertarELCombustible(controlCamiones);
				 */
				break;
			case 6:

				break;
			case 7:
				/*
				 * System.out.
				 * println("Has escogido la opción de ver todos los llenados de depósito");
				 * System.out.println("Lista depósitos: " + consulta.buscarCamiones());
				 */
				break;
			default:

			}

		} while (opcion1 != 0);
	}

}
