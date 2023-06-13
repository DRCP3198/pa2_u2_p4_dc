package com.example.demo.modelo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.demo.modelo.banco.CuentaBancaria;

public interface ICuentaService {
	
	public void aperturarCuenta(CuentaBancaria bancaria);
	public void modificarCuenta(CuentaBancaria bancaria);
	public CuentaBancaria consultarSaldo(Integer id);
	public void eliminar(Integer id);
	public void ingresarDeposito(Integer id, BigDecimal monto);
	

}
