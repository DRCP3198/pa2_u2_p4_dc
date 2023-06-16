package com.example.demo.repository;

import com.example.demo.modelo.Ciudadano;

public interface ICiudadanoRepository {
	
	public void insertar(Ciudadano ciudadano);
	public void actulizar(Ciudadano ciudadano);
	public Ciudadano buscar(Integer id);
	public void eliminar(Integer id);

}
