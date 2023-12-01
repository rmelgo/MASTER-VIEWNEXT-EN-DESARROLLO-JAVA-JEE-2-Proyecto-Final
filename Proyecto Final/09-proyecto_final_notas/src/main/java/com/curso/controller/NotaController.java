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

import com.curso.model.Nota;
import com.curso.service.NotaService;

@RestController
public class NotaController {

	@Autowired
	NotaService service;
	
	/**
	 * Este método añade una nota cuyos datos se proporcionan como parámetro
	 * 
	 * POST -> http://localhost:6060/notas
	 * 
	 * @param nota: Datos de la nota que se desea añadir
	 * @return Un mensaje informativo con el resultado de la operación
	 */
	
	//http://localhost:6060/notas
	@PostMapping(value="notas", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean añadirNota(@RequestBody Nota nota) {
		System.out.println(nota);
		return service.añadirNota(nota);
	}
	
	/**
	 * Este método modifica el valor numerico de una nota la cual se recibe como parametro. 
	 * Tambien se recibe como parametro el dni del alumno, el id de la asignatura y los temas de la nota a modificar
	 * 
	 * PUT -> http://localhost:6060/alumnos/notas?dni_alumno=x&id_asignatura=x&temas=x-x&nota=x
	 * 
	 * @param dni_alumno: Dni del alumno cuya nota se desea modificar
	 * @param id_asignatura: ID de la asignatura cuya nota se desea modificar
	 * @param temas: Temas de la nota que se desea modificar
	 * @param nota: Valor numerico de la nueva nota
	 * @return Un mensaje informativo con el resultado de la operación
	 */
	
	//http://localhost:6060/notas?dni_alumno=70925689Z&id_asignatura=1&temas=1-3&nota=10
	@PutMapping(value="notas", consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean modificarValorNota(@RequestParam String dni_alumno, @RequestParam int id_asignatura, @RequestParam String temas, @RequestParam float nota) {
		return service.modificarValorNota(dni_alumno, id_asignatura, temas, nota);
	}
	
	/**
	 * Este método elimina un nota donde se recibe como parametro el dni del alumno, el id de la asignatura y los temas de la nota a eliminar
	 * 
	 * DELETE -> http://localhost:6060/alumnos/notas?dni_alumno=x&id_asignatura=x&temas=x-x
	 * 
	 * @param dni_alumno: Dni del alumno cuya nota se desea eliminar
	 * @param id_asignatura: ID de la asignatura cuya nota se desea eliminar
	 * @param temas: Temas de la nota que se desea eliminar
	 * @return Un mensaje informativo con el resultado de la operación
	 */
	
	//http://localhost:6060/notas?dni_alumno=70925689Z&id_asignatura=11&temas=1-2
	@DeleteMapping(value="notas", produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean eliminarNota(@RequestParam String dni_alumno, @RequestParam int id_asignatura, @RequestParam String temas) {
		return service.eliminarNota(dni_alumno, id_asignatura, temas);
	}
	
	/**
	 * Este método obtiene una lista de las notas del alumno cuyo dni se pasa como parametro
	 * 
	 * GET -> http://localhost:6060/alumnos/notas/<dni del alumno>
	 * 
	 * @param dni_alumno: Dni del alumno 
	 * @return Una lista con las notas del alumno
	 */
	
	//http://localhost:6060/notas/70925689Z
	@GetMapping(value="notas/{dni}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> obtenerNotasDNI(@PathVariable("dni") String dni_alumno) {
		return service.obtenerNotasDNI(dni_alumno);
	}
	
	/**
	 * Este método obtiene una lista de las notas del alumno cuyo dni se pasa como parametro en una asignatura cuyo ID se pasa como parametro
	 * 
	 * GET -> http://localhost:6060/alumnos/notas/<dni del alumno>/<id de la asignatura>
	 * 
	 * @param dni_alumno: Dni del alumno
	 * @param id_asignatura: Id de la asignatura
	 * @return Una lista con las notas del alumno en la asignatura correspondiente
	 */
	
	//http://localhost:6060/notas/70925689Z/1
	@GetMapping(value="notas/{dni}/{id_asignatura}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> obtenerNotasDNIAsignatura(@PathVariable("dni") String dni_alumno, @PathVariable("id_asignatura") int id_asignatura) {
		return service.obtenerNotasDNIAsignatura(dni_alumno, id_asignatura);
	}
}
