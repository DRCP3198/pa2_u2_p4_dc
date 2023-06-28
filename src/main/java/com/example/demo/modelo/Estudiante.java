package com.example.demo.modelo;

import org.hibernate.annotations.CollectionId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "estudiante")
@Entity // cuando mapeo una tabla con un objeto pasa a ser una ENTIDAD
@NamedQueries({
		@NamedQuery(name = "Estudiante.buscaPorApellido", query = "select e from Estudiante e where e.apellido = :datoApellido"),
		@NamedQuery(name = "Estudiante.buscaPorNombre", query = "select e from Estudiante e where e.nombre = :datoNombre")

})
@NamedNativeQueries({
		@NamedNativeQuery(name = "Estudiante.buscarPorApellidoNative", query = "select * from Estudiante  where estu_apellido = :datoApellido", resultClass = Estudiante.class),
		@NamedNativeQuery(name = "Estudiante.buscarPorNombreNative", query = "select * from Estudiante  where estu_nombre = :datoNombre", resultClass = Estudiante.class)

})

public class Estudiante {

	@Id
	@SequenceGenerator(name = "seq_estudiante_generador", sequenceName = "seq_estudiante", allocationSize = 1)
	// AllocantionSize tiene que ver con el valor de incremento que se puso en la
	// base de datos
	@GeneratedValue(generator = "seq_estudiante_generador", strategy = GenerationType.SEQUENCE)
	@Column(name = "estu_id")
	private Integer id;

	@Column(name = "estu_cedula")
	private String cedula;

	@Column(name = "estu_nombre")
	private String nombre;

	@Column(name = "estu_apellido")
	private String apellido;

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	// SET y GET
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

}
