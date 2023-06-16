package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Ciudadano;
import com.example.demo.modelo.Empleado;
import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.banco.CuentaBancaria;
import com.example.demo.modelo.banco.service.ICuentaService;
import com.example.demo.service.ICiudadanoService;
import com.example.demo.service.IEmpleadoService;
import com.example.demo.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P4Dc1Application implements CommandLineRunner {

	@Autowired
	private IEmpleadoService empleadoService;
	
	@Autowired 
	private ICiudadanoService ciudadanoService;

	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4Dc1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Ciudadano ciudadano = new Ciudadano();
		ciudadano.setNombre("Dillan");
		ciudadano.setApellido("Coloma");
		ciudadano.setCedula("1751457167");
		
		
		Empleado empleado = new Empleado();
		empleado.setCiudadano(ciudadano);
		empleado.setCargo("Gerente");
		empleado.setSueldo(new BigDecimal(1500));
		ciudadano.setEmpleado(empleado);
		this.ciudadanoService.agregar(ciudadano);
		

		
	}

}
