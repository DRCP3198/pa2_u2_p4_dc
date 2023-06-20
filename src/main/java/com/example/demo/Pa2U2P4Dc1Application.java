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
		autor.setApellido("Bukowsky");
	    autorSetList.add(autor);
	    autor.setLibros(libroSetList);
		
		Libro libro = new Libro();
		libro.setTitulo("historias agonicas");
		libro.setEditorial("Bermeu");
		libroSetList.add(libro);
		libro.setAutores(autorSetList);
		
		this.autorService.agregar(autor);

	}

}
