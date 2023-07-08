package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Estudiante;
import com.example.demo.modelo.dto.EstudianteDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
@Transactional // Se necesita la anotación para acceder a la base de datos.
public class EstudianteRepoImpl implements IEstudianteRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Estudiante estudiante) {
		this.entityManager.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.entityManager.merge(estudiante);

	}

	@Override
	public Estudiante buscar(String cedula) {
		return this.entityManager.find(Estudiante.class, cedula);
	}

	@Override
	public void eliminar(String cedula) {
		Estudiante estu = this.buscar(cedula);
		this.entityManager.remove(estu);
	}

	// Query
	@Override
	public Estudiante seleccionarPorApellido(String apellido) {
		// TODO Auto-generated method stub
		// SQL= select * from estudiante where estu_apellido= ""
		// JPQL= select e from Estudiante e where e.apellido = "e"
		Query myQuery = this.entityManager.createQuery("select e from Estudiante e where e.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public List<Estudiante> seleccionarListaPorApellido(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("select e from Estudiante e where e.apellido = :datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getResultList();
	}

	@Override
	public Estudiante selecionarPorApellidoYNombre(String apellido, String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager
				.createQuery("select e from Estudiante e where e.apellido = :datoApellido and e.nombre=:datoNombre");
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
	}

	// TYPED
	@Override
	public Estudiante seleccionarPorApellidoTyped(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myTypedQuery = this.entityManager
				.createQuery("select e from Estudiante e where e.apellido = :datoApellido", Estudiante.class);
		myTypedQuery.setParameter("datoApellido", apellido);
		return myTypedQuery.getSingleResult();
	}

	// NAMED
	@Override
	public Estudiante seleccionaPorApellidoNamed(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscaPorApellido",
				Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionaPorApellidoNamedQuery(String apellido) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscaPorApellido");
		myQuery.setParameter("datoApellido", apellido);
		return (Estudiante) myQuery.getSingleResult();
	}

	// NATIVE QUERY
	@Override
	public Estudiante seleccionaPorApellidoNative(String apellido) {
		// TODO Auto-generated method stub
		Query query = this.entityManager
				.createNativeQuery("select * from Estudiante  where estu_apellido = :datoApellido", Estudiante.class);
		query.setParameter("datoApellido", apellido);
		return (Estudiante) query.getSingleResult();
	}

	@Override
	public Estudiante seleccionaPorApellidoNativeQueryNamed(String apellido) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorApellidoNative",
				Estudiante.class);
		myQuery.setParameter("datoApellido", apellido);
		return myQuery.getSingleResult();

	}

	@Override
	public Estudiante seleccionaPorNombreNamed(String nombre) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createNamedQuery("Estudiante.buscaPorNombre");
		myQuery.setParameter("datoNombre", nombre);
		return (Estudiante) myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionaPorNombreNativeQueryNamed(String nombre) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> myQuery = this.entityManager.createNamedQuery("Estudiante.buscarPorNombreNative",
				Estudiante.class);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.getSingleResult();
	}

	@Override
	public Estudiante seleccionaPorApellidoCriteriaApiQuery(String apellido) {
		// TODO Auto-generated method stub

		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		// 1. Especificamos el tipo de retorno que tiene mi Query
		CriteriaQuery<Estudiante> myCriteriaQuery = myBuilder.createQuery(Estudiante.class);

		// 2. Empezamos a crear el SQL
		// 2.1 Definimos el from(Root)
		Root<Estudiante> miTablaFrom = myCriteriaQuery.from(Estudiante.class); // FROM Estudiante
		// 3 Construir las condiciones de mi SQL por el where en criterial api las
		// condiciones
		// se las conoce como predicados
		// e.apellido= :datoApellido
		Predicate condicionApellido = myBuilder.equal(miTablaFrom.get("apellido"), apellido);
		// 4. Armamos mi SQL final
		myCriteriaQuery.select(miTablaFrom).where(condicionApellido);

		// 5. La ejecucion del Query lo realizamos con TypedQuery
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myCriteriaQuery);

		return myQueryFinal.getSingleResult();

	}

	@Override
	public Estudiante selecccionarEstudianteDinamico(String nombre, String apellido, Double peso) {
		// TODO Auto-generated method stub
		// la parte dinamica son las condiciones
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		// 1. Especificamos el tipo de retorno que tiene mi Query
		CriteriaQuery<Estudiante> myCriteriaQuery = builder.createQuery(Estudiante.class);
		// 2. Empezamos a crear el SQL
		// 2.1 Definimos el from(Root)
		Root<Estudiante> miTablaFrom = myCriteriaQuery.from(Estudiante.class); // FROM Estudiante
		// 3 Construir las condiciones de mi SQL por el where en criterial api las
		// condiciones
		// e.peso >100 e.nombre =:dato AND e.apellido = :dato
		// e.peso <=100 e.nombre =:dato OR e.apellido= :dato

		// e.nombre
		Predicate pNombre = builder.equal(miTablaFrom.get("nombre"), nombre);
		// e.apellido
		Predicate pApellido = builder.equal(miTablaFrom.get("apellido"), apellido);
		Predicate predicadoFinal = null;
		if (peso.compareTo(Double.valueOf(100)) <= 0) {
			predicadoFinal = builder.or(pNombre, pApellido);
		} else {
			predicadoFinal = builder.and(pNombre, pApellido);
		}
		// 4. Armamos mi SQL final
		myCriteriaQuery.select(miTablaFrom).where(predicadoFinal);

		// 5. La ejecucion del Query lo realizamos con TypedQuery
		TypedQuery<Estudiante> myQueryFinal = this.entityManager.createQuery(myCriteriaQuery);

		return myQueryFinal.getSingleResult();
	}

	//ELIMINAR
	//DELETE from estudiante where estu_nombre= ?
	//DELETE from Estudiante e where e.nombre = :datoNombre
	@Override
	public int eliminarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		Query myQuery = this.entityManager.createQuery("DELETE from Estudiante e where e.nombre = :datoNombre");
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.executeUpdate();
	}

	@Override
	public int actualizarPorApellidoYNombre(String nombre,String apellido) {
		// TODO Auto-generated method stub
		//UPDATE estudiante SET estu_nombre=? where estu_apellido =?
		//UPDATE Estudiante e SET e.nombre =:datoNombre where e.apellido=:datoApellido
		Query myQuery = this.entityManager.createQuery("UPDATE Estudiante e SET e.nombre =:datoNombre where e.apellido=:datoApellido");
		myQuery.setParameter("datoApellido", apellido);
		myQuery.setParameter("datoNombre", nombre);
		return myQuery.executeUpdate();
	}

	@Override
	public List<EstudianteDTO> seleccionarTodosDTO() {
		// TODO Auto-generated method stub
		TypedQuery<EstudianteDTO> query= this.entityManager.createQuery("SELECT new com.example.demo.modelo.dto.EstudianteDTO (e.nombre,e.apellido) from Estudiante e", EstudianteDTO.class);
		//TypedQuery<EstudianteDTO> query= this.entityManager.createQuery("SELECT new EstudianteDTO (e.nombre,e.apellido)", EstudianteDTO.class);
		return query.getResultList();
	}

}
