package com.example.demo;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Alumno;
import com.example.demo.modelo.Autor;
import com.example.demo.modelo.Libro;
import com.example.demo.modelo.Materia;
import com.example.demo.modelo.Matricula;
import com.example.demo.service.IAutorService;
import com.example.demo.service.ILibroService;
import com.example.demo.service.IMatriculaService;

@SpringBootApplication
public class Pa2U2P4Dc1Application implements CommandLineRunner {


	@Autowired
	private IMatriculaService iMatriculaService;
    
    
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4Dc1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

          Alumno alumno = new Alumno();
          alumno.setNombre("Henry");
          
          Materia materia = new Materia();
          materia.setNombre("Programación Avanzada 2");
          
          Matricula matricula = new Matricula();
          matricula.setAlumno(alumno);
          matricula.setMateria(materia);
          matricula.setFecha(LocalDateTime.now());
          matricula.setNumero("123456");
          
          this.iMatriculaService.matricular(matricula);
	}

}
