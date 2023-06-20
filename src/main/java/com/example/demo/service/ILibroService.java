package com.example.demo.service;

import com.example.demo.modelo.Libro;

public interface ILibroService {
	
	public void agregar(Libro libro);
	public void actualizar(Libro libro);
	public Libro encontrar(Integer id);
	public void borrar(Integer id);

}
