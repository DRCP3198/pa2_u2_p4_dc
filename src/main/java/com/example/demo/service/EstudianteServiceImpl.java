package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Estudiante;
import com.example.demo.repository.IEstudianteRepo;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	
	@Autowired
	private IEstudianteRepo estudianteRepo;
	
	@Override
	public void agregar(Estudiante estudiante) {
	this.estudianteRepo.insertar(estudiante);
		
	}

	@Override
	public void modificar(Estudiante estudiante) {
	this.estudianteRepo.actualizar(estudiante);	
		
	}

	@Override
	public Estudiante encontrar(String cedula) {
	
		return this.estudianteRepo.buscar(cedula);
	}

	@Override
	public void borrar(String cedula) {
		this.estudianteRepo.eliminar(cedula);
		
	}

	//QUERY
	@Override
	public Estudiante buscarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.seleccionarPorApellido(apellido);
	}

	@Override
	public List<Estudiante> buscarListaPorApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.seleccionarListaPorApellido(apellido);
	}

	@Override
	public Estudiante buscarPorApellidoYNombre(String apellido, String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.selecionarPorApellidoYNombre(apellido, nombre);
	}

	//TYPED QUERY
	@Override
	public Estudiante buscarPorApellidoTyped(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.seleccionarPorApellidoTyped(apellido);
	}

	@Override
	public Estudiante encontrarPorApellidoNamed(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.seleccionaPorApellidoNamed(apellido);
	}

	@Override
	public Estudiante encontrarPorApellidoNamedQuery(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.seleccionaPorApellidoNamedQuery(apellido);
	}

	@Override
	public Estudiante encontrarPorApellidoNative(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.seleccionaPorApellidoNative(apellido);
	}

	@Override
	public Estudiante encontrarPorApellidoNativeQueryNamed(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.seleccionaPorApellidoNativeQueryNamed(apellido);
	}

	@Override
	public Estudiante encontrarPorNombreNamed(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.seleccionaPorNombreNamed(nombre);
	}

	@Override
	public Estudiante encontrarPorNombreNativeQueryNamed(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.seleccionaPorNombreNativeQueryNamed(nombre);
	}

	@Override
	public Estudiante encontrarPorApellidoCriteriaApiQuery(String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.seleccionaPorApellidoCriteriaApiQuery(apellido);
	}

	@Override
	public Estudiante encontrarEstudianteDinamico(String nombre, String apellido, Double peso) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.selecccionarEstudianteDinamico(nombre, apellido, peso);
	}

	@Override
	public int borrarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.eliminarPorNombre(nombre);
	}

	@Override
	public int modificarPorApellidoYNombre(String nombre, String apellido) {
		// TODO Auto-generated method stub
		return this.estudianteRepo.actualizarPorApellidoYNombre(nombre, apellido);
	}

}
