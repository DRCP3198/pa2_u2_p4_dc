package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Estudiante;

public interface IEstudianteRepo {
	
	
	public void insertar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public Estudiante buscar(String cedula);
	public void eliminar(String cedula);
	
	//QUERY
	public Estudiante seleccionarPorApellido(String apellido);
	public List<Estudiante> seleccionarListaPorApellido(String apellido);
	public Estudiante selecionarPorApellidoYNombre(String apellido, String nombre);
	//TYPED QUERY
	public Estudiante seleccionarPorApellidoTyped(String apellido);

	//NAMED QUERY
	public Estudiante seleccionaPorApellidoNamed(String apellido);

}
