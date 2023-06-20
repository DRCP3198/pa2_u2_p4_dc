package com.example.demo.repository;

import com.example.demo.modelo.Autor;
import com.example.demo.modelo.Libro;

public interface ILibroRepo {
	
	public void insertar(Libro libro);
	public void modificar(Libro libro);
	public Libro buscar(Integer id);
	public void eliminar(Integer id);

}
