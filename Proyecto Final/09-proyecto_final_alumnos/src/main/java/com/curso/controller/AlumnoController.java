package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Alumno;
import com.curso.service.AlumnoService;

/**
 * Clase AlumnoController
 *
 * Controlador del microservicio de Alumno
 *
 * @author Raúl Melgosa
 * @version 1.0
 */

@RestController
public class AlumnoController {

	@Autowired
	AlumnoService service;
		
	/**
	 * Este método da de alta a un alumno cuyos datos se proporcionan como parámetro
	 * 
	 * POST -> http://localhost:8080/alumnos
	 * 
	 * @param alumno: Datos del alumno que se desea dar de alta
	 * @return Un mensaje informativo con el resultado de la operación
	 */
	
	//http://localhost:8080/alumnos
	@PostMapping(value="alumnos", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean altaAlumno(@RequestBody Alumno alumno) {
		return service.altaAlumno(alumno);
	}
	
	/**
	 * Este método modifica el nombre y apellidos de un alumno
	 * 
	 * PUT -> http://localhost:8080/alumnos/<dni del alumno a modificar>?nombre=x&apellido1=x&apellido2=x
	 * 
	 * @param dni: Dni del alumno a modificar
	 * @param nombre: Nombre del alumno modificado
	 * @param apellido1: Primer apellido del alumno modificado
	 * @param apellido2: Segundo apellido del alumno modificado
	 * @return Un mensaje informativo con el resultado de la operación
	 */
	
	//http://localhost:8080/alumnos/123456789M?nombre=Elba&apellido1=sado&apellido2=calvo
	@PutMapping(value="alumnos/{dni}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean modificarNombreAlumno(@PathVariable("dni") String dni, @RequestParam String nombre, @RequestParam String apellido1, @RequestParam String apellido2) {
		return service.modificarNombreAlumno(dni, nombre, apellido1, apellido2);
	}
	
	/**
	 * Este método elimina un alumno cuyo dni se pasa como parametro
	 * 
	 * DELETE -> http://localhost:8080/alumnos/<dni del alumno a eliminar>
	 * 
	 * @param dni: Dni del alumno a eliminar
	 * @return Un mensaje informativo con el resultado de la operación
	 */
	
	//http://localhost:8080/alumnos/123456789M
	@DeleteMapping(value="alumnos/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean eliminarAlumno(@PathVariable("dni") String dni) {
		return service.eliminarAlumno(dni);
	}
	
	/**
	 * Este método obtiene una lista con todos los alumnos
	 * 
	 * GET -> http://localhost:8080/alumnos
	 * 
	 * @return Una lista con todos los alumnos
	 */
	
	//http://localhost:8080/alumnos
	@GetMapping(value="alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Alumno> obtenerListaAlumnos() {
		return service.obtenerListaAlumnos();
	}
	
	/**
	 * Este método obtiene una lista con las asignaturas en las que se encuentra matriculado un alumno cuyo dni se pasa como parametro
	 * 
	 * GET -> http://localhost:8080/alumnos/<dni del alumno>/asignaturas
	 * 
	 * @param dni: Dni del alumno
	 * @return Una lista con las asignaturas en las que se encuentra matriculado el alumno
	 */
	
	//http://localhost:8080/alumnos/70925689Z/asignaturas
	@GetMapping(value="alumnos/{dni}/asignaturas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> obtenerListaAsignaturasAlumno(@PathVariable("dni") String dni) {
		return service.obtenerListaAsignaturasAlumno(dni);
	}
	
	/**
	 * Este método obtiene una lista con las notas de un alumno cuyo dni se pasa como parametro
	 * 
	 * GET -> http://localhost:8080/alumnos/<dni del alumno>/alumnos
	 * 
	 * @param dni: Dni del alumno
	 * @return Una lista con las notas del alumno
	 */
	
	//http://localhost:8080/alumnos/70925689Z/alumnos
	@GetMapping(value="alumnos/{dni}/alumnos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> obtenerListaNotasAlumno(@PathVariable("dni") String dni) {
		return service.obtenerListaNotasAlumno(dni);
	}
	
	/**
	 * Este método obtiene una lista con las notas de un alumno cuyo dni se pasa como parametro en una determianda asignatura cuyo nombre se pasa como parametro. 
	 * Esta lista inluye un apartado final donde se muestra la nota media del alumno en dicha asignatura.
	 * 
	 * GET -> http://localhost:8080/alumnos/<dni del alumno>/<nombre de la asignatura>
	 * 
	 * @param dni: Dni del alumno
	 * @param nombre_asignatura: Nombre de la asignatura
	 * @return Una lista con las notas del alumno en la asignatura junto con la nota media del alumno en la asignatura
	 */
	
	//http://localhost:8080/alumnos/70925689Z/Lengua
	@GetMapping(value="alumnos/{dni}/{nombre_asignatura}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> obtenerNotaMediaAlumnoAsignatura(@PathVariable("dni") String dni, @PathVariable("nombre_asignatura") String nombre_asignatura) {
		return service.obtenerNotaMediaAlumnoAsignatura(dni, nombre_asignatura);
	}
	
	/**
	 * Este método matricula al alumno cuyo se pasa como parametro en la asignatura cuyo nombre se pasa como parametro
	 * 
	 * POST -> http://localhost:8080/alumnos/<dni del alumno>/<nombre de la asignatura>
	 * 
	 * @param dni: Dni del alumno
	 * @param nombre_asignatura: Nombre de la asignatura
	 * @return Un mensaje informativo con el resultado de la operación
	 */
	
	//http://localhost:8080/alumnos/70925689Z/Aplaudir
	@PostMapping(value="alumnos/{dni}/{nombre_asignatura}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean matricularAlumnoAsignatura(@PathVariable("dni") String dni, @PathVariable("nombre_asignatura") String nombre_asignatura) {
		return service.matricularAlumnoAsignatura(dni, nombre_asignatura);
	}
	
	/**
	 * Este método desmatricula al alumno cuyo se pasa como parametro en la asignatura cuyo nombre se pasa como parametro
	 * 
	 * DELETE -> http://localhost:8080/alumnos/<dni del alumno>/<nombre de la asignatura>
	 * 
	 * @param dni: Dni del alumno
	 * @param nombre_asignatura: Nombre de la asignatura
	 * @return Un mensaje informativo con el resultado de la operación
	 */
	
	//http://localhost:8080/alumnos/70925689Z/Aplaudir
	@DeleteMapping(value="alumnos/{dni}/{nombre_asignatura}", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean desmatricularAlumnoAsignatura(@PathVariable("dni") String dni, @PathVariable("nombre_asignatura") String nombre_asignatura) {
		return service.desmatricularAlumnoAsignatura(dni, nombre_asignatura);
	}
}
