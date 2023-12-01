package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Nota;
import com.curso.model.NotaKey;

/**
 * Interfaz NotaDao
 *
 * Interfaz que proporciona los metodos y querys que seran implementados por la clase NotaServiceImpl
 *
 * @author Raúl Melgosa
 * @version 1.0
 */

public interface NotaDao extends JpaRepository<Nota, NotaKey> {

	/**
	 * Este método obtiene el identificador de la asignatura, los temas y el valor numerico de las notas de una alumno cuyo DNI se pasa como parametro
	 *  
	 * @param dni: Dni del alumno
	 * @return Una lista con las notas del alumno
	 */
	
	@Query("SELECT n.id.idAsignatura, n.id.temas, n.nota from Nota n where n.id.dniAlumno = :dni")
	public List<String> findAllByDNI(String dni);
	
	/**
	 * Este método obtiene  los temas y el valor numerico de las notas de una alumno cuyo DNI se pasa como parametro en la asignatura cuyo ID se pasa como parametro
	 *  
	 * @param dni: Dni del alumno
	 * @param id_asignatura: ID de la asignatura
	 * @return Una lista con las notas del alumno en la asignatura determinada
	 */
	
	@Query("SELECT n.id.temas, n.nota from Nota n where n.id.dniAlumno = :dni AND n.id.idAsignatura = :id_asignatura")
	public List<String> findAllByDNIAsignatura(String dni, int id_asignatura);
}
