package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Estudiante;
import com.example.demo.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P4Dc1Application implements CommandLineRunner {

	
	@Autowired 
	private IEstudianteService estudianteService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4Dc1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Estudiante estu = new Estudiante();
		estu.setNombre("Renato");
		estu.setApellido("Pozo");
		estu.setCedula("1751457181");
		
		this.estudianteService.agregar(estu);
		
		this.estudianteService.modificar(estu);
		this.estudianteService.encontrar("1751457181");
		this.estudianteService.borrar("1751457167");
		
	
	}

}
