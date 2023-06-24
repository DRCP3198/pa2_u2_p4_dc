package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Estudiante;

public interface IEstudianteService {

	public void agregar(Estudiante estudiante);

	public void modificar(Estudiante estudiante);

	public Estudiante encontrar(String cedula);

	public void borrar(String cedula);

	// QUERY
	public Estudiante buscarPorApellido(String apellido);

	public List<Estudiante> buscarListaPorApellido(String apellido);

	public Estudiante buscarPorApellidoYNombre(String apellido, String nombre);

	// TYPED QUERY
	public Estudiante buscarPorApellidoTyped(String apellido);
}
