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
       estu.setApellido("Andino");
       estu.setCedula("123456789");
       estu.setNombre("Jordan");
       estu.setPeso(Double.valueOf(44.5));
      this.estudianteService.agregar(estu);
//       Estudiante a=this.estudianteService.encontrarPorApellidoNamed("Perez");
//       System.out.println(a);
//       Estudiante b=this.estudianteService.encontrarPorApellidoNamedQuery("Perez");
//       System.out.println(b);
       
//       this.estudianteService.encontrarPorApellidoNative("Perez");
//       this.estudianteService.encontrarPorApellidoNativeQueryNamed("Perez");
//       this.estudianteService.encontrarPorNombreNamed("Ale");
//       this.estudianteService.encontrarPorNombreNativeQueryNamed("Ale");
//       this.estudianteService.encontrarPorApellidoCriteriaApiQuery("Perez");
      Estudiante estudiante= this.estudianteService.encontrarEstudianteDinamico("Ricardo", "Andrade", Double.valueOf(100));
      System.out.println(estudiante);	
      System.out.println("ELIMINAR");
      Integer registro=this.estudianteService.borrarPorNombre("Jordan");
      System.out.println("Se elimino: " +registro);
      System.out.println("ACTUALIZAR");
      Integer registro1=this.estudianteService.modificarPorApellidoYNombre("RICKY", "Andrade");
      System.out.println("Se actualizo: " +registro1 +"Estudiante");
	}

}
