package com.example.demo.repository;

import com.example.demo.modelo.Matricula;

public interface IMatriculaRepository {
	
	public void insertar(Matricula matricula);
	public void actualizar(Matricula matricula);
	public Matricula buscar(Integer id);
	public void eliminar(Integer id);

}
