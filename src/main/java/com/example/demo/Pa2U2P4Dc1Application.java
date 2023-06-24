package com.example.demo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Alumno;
import com.example.demo.modelo.Autor;
import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.Libro;
import com.example.demo.modelo.Materia;
import com.example.demo.modelo.Matricula;
import com.example.demo.service.IAutorService;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.ILibroService;
import com.example.demo.service.IMatriculaService;

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
       estu.setApellido("Perez");
       estu.setCedula("200200100");
       estu.setNombre("Ale");
       
       //this.estudianteService.agregar(estu);
       this.estudianteService.buscarPorApellido("Perez");
       Estudiante e= this.estudianteService.buscarPorApellidoYNombre("Perez", "Ale");
       System.out.println("QUERY");
       System.out.println("Buscar por apellido y nombre: "+e);
	   List<Estudiante> estudiante = this.estudianteService.buscarListaPorApellido("Pastrano");
	   for (Estudiante estudiante2 : estudiante) {
		System.out.println("Buscar reporte de estudiantes: "+estudiante2);
	}
	  System.out.println(); 
	  System.out.println("TYPED QUERY");
	  Estudiante e1= this.estudianteService.buscarPorApellidoTyped("Perez");
	  System.out.println(e1);
	}

}
