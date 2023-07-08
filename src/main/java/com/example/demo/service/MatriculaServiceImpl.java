package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Matricula;
import com.example.demo.modelo.dto.MatriculaDTO;
import com.example.demo.repository.IMatriculaRepository;

@Service
public class MatriculaServiceImpl implements IMatriculaService{

	@Autowired
	private IMatriculaRepository iMatriculaRepository;
	@Override
	public void matricular(Matricula matricula) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.insertar(matricula);
	
	}
	@Override
	public void modificar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.actualizar(matricula);
	}
	@Override
	public Matricula encontrar(Integer id) {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.buscar(id);
	}
	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iMatriculaRepository.eliminar(id);
	}
	@Override
	public List<MatriculaDTO> reporteAlumnoNomYMateriaNom() {
		// TODO Auto-generated method stub
		return this.iMatriculaRepository.buscarTodas();
	}
}
