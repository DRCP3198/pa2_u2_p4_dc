package com.example.demo.service;

import com.example.demo.modelo.Matricula;

public interface IMatriculaService {
	
	public void matricular(Matricula matricula);
	public void modificar(Matricula matricula);
	public Matricula encontrar(Integer id);
	public void borrar(Integer id);


}
