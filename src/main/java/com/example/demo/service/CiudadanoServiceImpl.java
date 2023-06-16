package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Ciudadano;
import com.example.demo.repository.ICiudadanoRepository;

@Service
public class CiudadanoServiceImpl implements ICiudadanoService{

	@Autowired
	private ICiudadanoRepository ciudadanoRepository;
	
	@Override
	public void agregar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.insertar(ciudadano);
	}

	@Override
	public void modificar(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.actulizar(ciudadano);
	}

	@Override
	public Ciudadano encontrar(Integer id) {
		// TODO Auto-generated method stub
		return this.ciudadanoRepository.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.ciudadanoRepository.eliminar(id);
	}

}
