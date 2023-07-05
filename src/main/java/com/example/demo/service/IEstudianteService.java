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

	// NAMED QUERY
	public Estudiante encontrarPorApellidoNamed(String apellido);

	public Estudiante encontrarPorNombreNamed(String nombre);

	public Estudiante encontrarPorApellidoNamedQuery(String apellido);

	// NATIVE QUERY
	public Estudiante encontrarPorApellidoNative(String apellido);

	// NATIVEQUERYNamed
	public Estudiante encontrarPorApellidoNativeQueryNamed(String apellido);

	public Estudiante encontrarPorNombreNativeQueryNamed(String nombre);

	// CRITERIAL API QUERY
	public Estudiante encontrarPorApellidoCriteriaApiQuery(String apellido);

	public Estudiante encontrarEstudianteDinamico(String nombre, String apellido, Double peso);
	
	//ELIMINAR
    public int borrarPorNombre(String nombre);
    //ACTUALIZAR
    public int modificarPorApellidoYNombre(String nombre,String apellido);
}
