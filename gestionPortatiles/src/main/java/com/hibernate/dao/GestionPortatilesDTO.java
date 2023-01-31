package com.hibernate.dao;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

import com.hibernate.dal.GestionAlumnos;

@Component
public class GestionPortatilesDTO {
	
	private String id_ordenador;
	private String md_uuid;
	private Calendar md_date;
	private String modelo;
	private String marca;
	GestionAlumnos alumno;
	
	//Getters & Setters
	
	public String getId_ordenador() {
		return id_ordenador;
	}
	public void setId_ordenador(String id_ordenador) {
		this.id_ordenador = id_ordenador;
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
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public GestionAlumnos getAlumno() {
		return alumno;
	}
	public void setAlumno(GestionAlumnos alumno) {
		this.alumno = alumno;
	}
	
	
	//Constructores
	public GestionPortatilesDTO(String md_uuid, Calendar md_date, String modelo, String marca, GestionAlumnos alumno) {
		super();
		this.md_uuid = md_uuid;
		this.md_date = md_date;
		this.modelo = modelo;
		this.marca = marca;
		this.alumno = alumno;
	}
	
	public GestionPortatilesDTO() {
		super();
	}
	
	//ToString
	
	
	
	@Override
	public String toString() {
		return "GestionOrdenadores [md_uuid=" + md_uuid + ", md_date=" + md_date.getTime()
				+ ", modelo=" + modelo + ", marca=" + marca + ", alumno=" + alumno + "]";
	}

}
