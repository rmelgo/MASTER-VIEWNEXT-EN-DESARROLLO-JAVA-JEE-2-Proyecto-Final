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
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Asignatura;
import com.curso.service.AsignaturaService;

/**
 * Clase AsignaturasController
 *
 * Controlador del microservicio de Asignatura
 *
 * @author Raúl Melgosa
 * @version 1.0
 */

@RestController
public class AsignaturasController {

	@Autowired
	AsignaturaService service;
	
	/**
	 * Este método da de alta a una asignatura cuyos datos se proporcionan como parámetro
	 * 
	 * POST -> http://localhost:7070/asignaturas
	 * 
	 * @param asignatura: Datos de la asignatura que se desea dar de alta
	 * @return Un mensaje informativo con el resultado de la operación
	 */
	
	//http://localhost:7070/asignaturas
	@PostMapping(value = "asignaturas", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean añadirAsignatura(@RequestBody Asignatura asignatura) {
		return service.añadirAsignatura(asignatura);
	}
	
	/**
	 * Este método elimina una asignatura cuyo ID se pasa como parametro
	 * 
	 * DELETE -> http://localhost:7070/asignaturas/<id de la asignatura a eliminar>
	 * 
	 * @param id_asignatura: ID del asignatura a eliminar
	 * @return Un mensaje informativo con el resultado de la operación
	 */
	
	//http://localhost:7070/asignaturas/11
	@DeleteMapping(value = "asignaturas/{id_asignatura}", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean eliminarAsignatura(@PathVariable("id_asignatura") int id_asignatura) {
		return service.eliminarAsignatura(id_asignatura);
	}
	
	/**
	 * Este método obtiene los alumnos matriculados a una asignatura cuyo ID se para como parametro
	 * 
	 * GET -> http://localhost:7070/asignaturas/<id de la asignatura>
	 * 
	 * @param id_asignatura: ID de la asignatura 
	 * @return Un mensaje informativo con el resultado de la operación
	 */
	
	//http://localhost:7070/asignaturas/11
	@GetMapping(value = "asignaturas/{id_asignatura}", produces = MediaType.APPLICATION_JSON_VALUE)
	public int obtenerNumeroAlumnosMatriculadosAsignatura(@PathVariable("id_asignatura") int id_asignatura) {
		return service.obtenerNumeroAlumnosMatriculadosAsignatura(id_asignatura);
	}
	
	/**
	 * Este método obtiene una lista con todas las asignaturas
	 * 
	 * GET -> http://localhost:7070/asignaturas
	 * 
	 * @return Una lista con todas las asignaturas
	 */
	
	//http://localhost:7070/asignaturas
	@GetMapping(value = "asignaturas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Asignatura> obtenerListaAsignatura() {
		return service.obtenerListaAsignatura();
	}
	
	/**
	 * Este método modifica el numero de alumnos matriculados en una asignatura cuyo ID se pasa como parametro
	 * 
	 * PUT -> http://localhost:7070/asignaturas/<id de la asignatura>/<tipo de operacion>
	 * 
	 * @param id_asignatura: ID de la asignatura 
	 * @param tipo_operacion: + si es un incremento y - si es un decremento
	 * @return Un mensaje informativo con el resultado de la operación
	 */
	
	//http://localhost:7070/asignaturas/11/+
	@PutMapping(value = "asignaturas/{id_asignatura}/{tipo_operacion}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean modificarAlumnosMatriculadosAsignatura(@PathVariable("id_asignatura") int id_asignatura, @PathVariable("tipo_operacion") String tipo_operacion) {
		return service.modificarAlumnosMatriculadosAsignatura(id_asignatura, tipo_operacion);
	}
	
	/**
	 * Este método obtiene el nombre de una asignatura cuyo ID se pasa como parametro
	 * 
	 * GET -> http://localhost:7070/asignaturas/<id de la asignatura>
	 * @param id_asignatura: ID de la asignatura
	 * @return El nombre de la asignatura
	 */
	
	//http://localhost:7070/asignaturas/1/nombre
	@GetMapping(value = "asignaturas/{id_asignatura}/nombre", produces = MediaType.APPLICATION_JSON_VALUE)
	public String obtenerNombreAsignatura(@PathVariable("id_asignatura") int id_asignatura) {
		return service.obtenerNombreAsignatura(id_asignatura);
	}
	
	/**
	 * Este método obtiene el ID de una asignatura cuyo nombre se pasa como parametro
	 * 
	 * GET -> http://localhost:7070/asignaturas/<nombre de la asignatura>/id
	 * 
	 * @param nombre_asignatura: Nombre de la asignatura
	 * @return El ID de la asignatura
	 */
	
	//http://localhost:7070/asignaturas/Lengua/id
	@GetMapping(value = "asignaturas/{nombre_asignatura}/id", produces = MediaType.APPLICATION_JSON_VALUE)
	public int obtenerIdAsignatura(@PathVariable("nombre_asignatura") String nombre_asignatura) {
		return service.obtenerIdAsignatura(nombre_asignatura);
	}
	
	/**
	 * Este método obtiene el numero de temas de una asignatura cuyo nombre se pasa como parametro
	 * 
	 * GET -> http://localhost:7070/asignaturas/<nombre de la asignatura>/temas
	 * 
	 * @param nombre_asignatura: Nombre de la asignatura
	 * @return El numero de la asignatura
	 */
	
	//http://localhost:7070/asignaturas/Lengua/temas
	@GetMapping(value = "asignaturas/{nombre_asignatura}/temas", produces = MediaType.APPLICATION_JSON_VALUE)
	public int obtenerTemasAsignatura(@PathVariable("nombre_asignatura") String nombre_asignatura) {
		return service.obtenerTemasAsignatura(nombre_asignatura);
	}
}
