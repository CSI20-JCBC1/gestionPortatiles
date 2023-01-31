package com.hibernate.dao;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.hibernate.dal.GestionPortatiles;

@Component
public class GestionAlumnosDTO {
	
	private String id_alumno;
	private String md_uuid;
	private Calendar md_date;
	private String nombre;
	private String apellidos;
	private String num_telefono;
	GestionPortatiles portatiles;
	
	//Getters & Setters
	public String getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(String id_alumno) {
		this.id_alumno = id_alumno;
	}
	public String getMd_uuid() {
		return md_uuid;
	}
	public void setMd_uuid(String md_uuid) {
		this.md_uuid = md_uuid;
	}
	public Calendar getMd_date() {
		return md_date;
	}
	public void setMd_date(Calendar md_date) {
		this.md_date = md_date;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNum_telefono() {
		return num_telefono;
	}
	public void setNum_telefono(String num_telefono) {
		this.num_telefono = num_telefono;
	}
	public GestionPortatiles getPortatiles() {
		return portatiles;
	}
	public void setPortatiles(GestionPortatiles portatiles) {
		this.portatiles = portatiles;
	}
	
	//Construcores
	
	public GestionAlumnosDTO(String md_uuid, Calendar md_date, String nombre, String apellidos, String num_telefono,
			GestionPortatiles portatiles) {
		super();
		this.md_uuid = md_uuid;
		this.md_date = md_date;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.num_telefono = num_telefono;
		this.portatiles = portatiles;
	}
	
	public GestionAlumnosDTO(String md_uuid, Calendar md_date, String nombre, String apellidos, String num_telefono) {
		super();
		this.md_uuid = md_uuid;
		this.md_date = md_date;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.num_telefono = num_telefono;
		
	}
	
	
	public GestionAlumnosDTO() {
		super();
	}
	
	//ToString
	@Override
	public String toString() {
		return "GestionAlumnos [id_alumno=" + id_alumno + ", md_uuid=" + md_uuid + ", md_date=" + md_date + ", nombre="
				+ nombre + ", apellidos=" + apellidos + ", num_telefono=" + num_telefono + ", portatiles=" + portatiles
				+ "]";
	}
	


}
