package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Autor;
import com.example.demo.modelo.Libro;
import com.example.demo.service.IAutorService;
import com.example.demo.service.ILibroService;

@SpringBootApplication
public class Pa2U2P4Dc1Application implements CommandLineRunner {


	@Autowired
	private IAutorService autorService;
    @Autowired
    private ILibroService iLibroService;
    
    
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4Dc1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Set<Autor> autorSetList = new HashSet<>();
		Set<Libro>libroSetList = new HashSet<>();
		
		Autor autor= new Autor();
		autor.setNombre("Charles");
		autor.setApellido("Bukowski");
	    autorSetList.add(autor);
	    autor.setLibros(libroSetList);
	    
	    Autor autor2= new Autor();
		autor2.setNombre("Jimeno");
		autor2.setApellido("Alterex");
	    autorSetList.add(autor2);
	    autor2.setLibros(libroSetList);
		
		
//		Libro libro = new Libro();
//		libro.setTitulo("La senada del Perdedor");
//		libro.setEditorial("Bermeu");
//		libroSetList.add(libro);
//		libro.setAutores(autorSetList);
//		
//		Libro libro2 = new Libro();
//		libro2.setTitulo("Escritos de un viejo Inocente");
//		libro2.setEditorial("Astronum");
//		libroSetList.add(libro2);
//		libro2.setAutores(autorSetList);
		
		Libro libro3 = new Libro();
		libro3.setTitulo("Pulp");
		libro3.setEditorial("Astronum");
		libroSetList.add(libro3);
		libro3.setAutores(autorSetList);
		
		this.iLibroService.agregar(libro3);
		libro3.setEditorial("Antares");
		this.iLibroService.actualizar(libro3);
		this.iLibroService.encontrar(4);
		this.iLibroService.borrar(3);
	

	}

}
