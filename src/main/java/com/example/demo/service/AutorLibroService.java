package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Autor;
import com.example.demo.repository.IAutorRepo;

@Service
public class AutorLibroService implements IAutorService{
	
	@Autowired
	private IAutorRepo autorRepo;

	@Override
	public void agregar(Autor autor) {
		// TODO Auto-generated method stub
		this.autorRepo.insertar(autor);
	}

	@Override
	public void actualizar(Autor autor) {
		// TODO Auto-generated method stub
		this.autorRepo.modificar(autor);
	}

	@Override
	public Autor encontrar(Integer id) {
		// TODO Auto-generated method stub
		return this.autorRepo.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.autorRepo.eliminar(id);
	}
	

}
