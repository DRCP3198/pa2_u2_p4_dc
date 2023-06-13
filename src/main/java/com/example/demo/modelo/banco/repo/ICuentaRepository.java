package com.example.demo.modelo.banco.repo;

import com.example.demo.modelo.banco.CuentaBancaria;

public interface ICuentaRepository {
	
	public void insertar(CuentaBancaria bancaria);
	public void actualizar(CuentaBancaria bancaria);
	public CuentaBancaria buscar(Integer id);
	public void borrar(Integer id);

}
