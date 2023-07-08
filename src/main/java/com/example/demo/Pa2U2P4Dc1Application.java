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
import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;
import com.example.demo.modelo.Libro;
import com.example.demo.modelo.Materia;
import com.example.demo.modelo.Matricula;
import com.example.demo.modelo.dto.EstudianteDTO;
import com.example.demo.modelo.dto.MatriculaDTO;
import com.example.demo.service.IAutorService;
import com.example.demo.service.IEstudianteService;
import com.example.demo.service.IHabitacionService;
import com.example.demo.service.IHotelService;
import com.example.demo.service.ILibroService;
import com.example.demo.service.IMatriculaService;

@SpringBootApplication
public class Pa2U2P4Dc1Application implements CommandLineRunner {

	@Autowired
	private IEstudianteService estudianteService;
	
	@Autowired
	private IMatriculaService iMatriculaService;
	
	@Autowired
	private IHotelService iHotelService;
	
	@Autowired
	private IHabitacionService habitacionService;

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
		//this.estudianteService.agregar(estu);
		System.out.println();
		System.out.println("Reporte estudiantes");
		List<EstudianteDTO> reporte = this.estudianteService.reporteDTO();
		for (EstudianteDTO estudianteDTO : reporte) {
			System.out.println(estudianteDTO);
		}
		System.out.println();
		System.out.println("Matricula Nombre y Materia");
		List<MatriculaDTO> reporteMatricula = this.iMatriculaService.reporteAlumnoNomYMateriaNom();
		for (MatriculaDTO matriculaDTO : reporteMatricula) {
			System.out.println(matriculaDTO);
		}
		
		System.out.println();
		System.out.println("Imprimir el Hotel");
		Hotel hotel = this.iHotelService.encontrar(2);
		System.out.println(hotel.getNombre());
		
		 Hotel consulta = this.iHotelService.encontrar(2);

		 //consulta.getHabitaciones();
		 for (Habitacion habitacion : consulta.getHabitaciones()) {

			System.out.println("Rerporte"+habitacion);

		}
		//System.out.println(nombreshabitaciones.getHabitaciones());
	}

}
