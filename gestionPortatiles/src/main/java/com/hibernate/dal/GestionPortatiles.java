package com.hibernate.dal;

import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table(name= "prt_tch_gestion_portatiles", schema= "dlk_gestm_alm_prt")
public class GestionPortatiles {
	
		//Atributos
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id_portatil", unique=true, nullable=false)
		private Integer id_ordenador;
		@Column(name="md_uuid",nullable=false)
		private String md_uuid;
		@Column(name="md_date",nullable=false)
		@Temporal(TemporalType.TIMESTAMP)
		private Calendar md_date;
		@Column(name="modelo",nullable=false)
		private String modelo;
		@Column(name="marca",nullable=false)
		private String marca;
		@OneToOne(mappedBy="portatiles")	
		GestionAlumnos alumno;
		
		//Getters & Setters
		
		public Integer getId_ordenador() {
			return id_ordenador;
		}
		public void setId_ordenador(Integer id_ordenador) {
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
		
		//ToString
		
		@Override
		public String toString() {
			return "GestionOrdenadores [md_uuid=" + md_uuid + ", md_date=" + md_date.getTime()
					+ ", modelo=" + modelo + ", marca=" + marca + ", alumno=" + alumno + "]";
		}


}
