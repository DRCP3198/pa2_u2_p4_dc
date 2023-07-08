package com.example.demo.modelo.dto;

import com.example.demo.modelo.Estudiante;

public class MatriculaDTO {
	
	private String nombreEstudiante;
	private String nombreMateria;
	
	public MatriculaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	

	public MatriculaDTO(String nombreEstudiante, String nombreMateria) {
		super();
		this.nombreEstudiante = nombreEstudiante;
		this.nombreMateria = nombreMateria;
	}



	//SET y GET
	public String getNombreEstudiante() {
		return nombreEstudiante;
	}

	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}



	@Override
	public String toString() {
		return "MatriculaDTO [nombreEstudiante=" + nombreEstudiante + ", nombreMateria=" + nombreMateria + "]";
	}
	
	

}
