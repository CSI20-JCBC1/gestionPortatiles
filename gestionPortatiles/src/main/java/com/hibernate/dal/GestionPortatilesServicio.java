package com.hibernate.dal;

import java.util.List;

public interface GestionPortatilesServicio {
	
	public void insertarPortatil(GestionPortatiles gestionPortatiles);

	public List<GestionPortatiles> buscarPortatiles();

}
