package com.curso.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Alumno;

/**
 * Interfaz AlumnoDao
 *
 * Interfaz que proporciona los metodos y querys que seran implementados por la clase AlumnoServiceImpl
 *
 * @author Raúl Melgosa
 * @version 1.0
 */

public interface AlumnoDao extends JpaRepository<Alumno, String> {

	/**
	 * Este método obtiene el identificador de las asignaturas a las que esta matriculado un alumno
	 *  
	 * @param dni: Dni del alumno
	 * @return Una lista con los identificadores de las asignaturas a las que esta matriculado el alumno
	 */
	
	@Query("SELECT aa.id.idAsignatura from Alumno a JOIN AlumnoAsignatura aa ON a.dni = aa.id.dniAlumno where aa.id.dniAlumno = :dni")
	public List<String> findIdAsignaturasDNI(String dni);
}
