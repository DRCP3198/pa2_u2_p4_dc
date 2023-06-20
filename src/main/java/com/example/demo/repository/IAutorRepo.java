package com.example.demo.repository;

import com.example.demo.modelo.Autor;

public interface IAutorRepo {
	
	public void insertar(Autor autor);
	public void modificar(Autor autor);
	public Autor buscar(Integer id);
	public void eliminar(Integer id);

}
