package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Asignatura;

/**
 * Interfaz AsignaturaDao
 *
 * Interfaz que proporciona los metodos y querys que seran implementados por la clase AsignaturaServiceImpl
 *
 * @author Raúl Melgosa
 * @version 1.0
 */

public interface AsignaturaDao extends JpaRepository<Asignatura, Integer> {
	
	/**
	 * Este método obtiene el nombre de las asignatura cuyo ID se proporciona como parametro
	 *  
	 * @param id_asignatura: ID de la asignatura
	 * @return El nombre de la asignatura
	 */
	
	@Query("SELECT a.nombre from Asignatura a where a.idAsignatura = :id_asignatura")
	public String obtenerAsignaturaID(int id_asignatura);
	
	/**
	 * Este método obtiene el ID de las asignatura cuyo nombre se proporciona como parametro
	 *  
	 * @param nombre_asignatura: Nombre de la asignatura
	 * @return El ID de la asignatura
	 */
	
	@Query("SELECT a.idAsignatura from Asignatura a where a.nombre = :nombre_asignatura")
	public String obtenerAsignaturaNombre(String nombre_asignatura);
	
	/**
	 * Este método obtiene el numero de temas de las asignatura cuyo nombre se proporciona como parametro
	 *  
	 * @param nombre_asignatura: Nombre de la asignatura
	 * @return El numero de temas de la asignatura
	 */
	
	@Query("SELECT a.numTemas from Asignatura a where a.nombre = :nombre_asignatura")
	public String obtenerTemasAsignatura(String nombre_asignatura);
}
