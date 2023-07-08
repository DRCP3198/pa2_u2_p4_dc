package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Matricula;
import com.example.demo.modelo.dto.MatriculaDTO;

public interface IMatriculaRepository {
	
	public void insertar(Matricula matricula);
	public void actualizar(Matricula matricula);
	public Matricula buscar(Integer id);
	public void eliminar(Integer id);
	public List<MatriculaDTO> buscarTodas();

}
