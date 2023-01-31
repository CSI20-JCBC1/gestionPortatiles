package com.hibernate.dal;

import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table(name= "alm_tch_gestion_alumnos", schema= "dlk_gestm_alm_prt")
public class GestionAlumnos {
	
	//Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_alumno", unique=true, nullable=false)
	private String id_alumno;
	@Column(name="md_uuid",nullable=false)
	private String md_uuid;
	@Column(name="md_date",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar md_date;
	@Column(name="nombre",nullable=false)
	private String nombre;
	@Column(name="apellidos",nullable=false)
	private String apellidos;
	@Column(name="num_telefono",nullable=false)
	private String num_telefono;
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="id_portatil", nullable=true)
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
	
	//ToString
	@Override
	public String toString() {
		return "GestionAlumnos [id_alumno=" + id_alumno + ", md_uuid=" + md_uuid + ", md_date=" + md_date + ", nombre="
				+ nombre + ", apellidos=" + apellidos + ", num_telefono=" + num_telefono + ", portatiles=" + portatiles
				+ "]";
	}
	




}
