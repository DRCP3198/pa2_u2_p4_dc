package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.banco.CuentaBancaria;
import com.example.demo.modelo.banco.service.ICuentaService;
import com.example.demo.service.IEstudianteService;

@SpringBootApplication
public class Pa2U2P4Dc1Application implements CommandLineRunner {

	
	@Autowired 
	private ICuentaService cuentaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4Dc1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		CuentaBancaria cuentaBancaria = new CuentaBancaria();
		cuentaBancaria.setCedulaPropietario("1751457167");
		cuentaBancaria.setFecha(LocalDateTime.now());
		cuentaBancaria.setNumero("121212");
		cuentaBancaria.setSaldo(new BigDecimal(200));
		cuentaBancaria.setTipo("Corriente");
		
		//this.cuentaService.aperturarCuenta(cuentaBancaria);
		this.cuentaService.ingresarDeposito(1, new BigDecimal(200));
		
	}

}
