package com.curso.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.dao.AlumnoAsignaturaDao;
import com.curso.dao.AlumnoDao;
import com.curso.model.Alumno;
import com.curso.model.AlumnoAsignatura;
import com.curso.model.AlumnoAsignaturaKey;

/**
 * Clase AlumnoServiceImpl
 *
 * Servicio del microservicio de Alumno
 *
 * @author Raúl Melgosa
 * @version 1.0
 */

@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	AlumnoDao dao;
	
	@Autowired
	AlumnoAsignaturaDao daoAA;
	
	@Autowired
	RestTemplate template;
	
	String url_asignaturas = "http://localhost:7070/asignaturas";
	String url_notas = "http://localhost:6060/notas";
	
	/**
	 * Este método da de alta a un alumno cuyos datos se proporcionan como parámetro
	 * 
	 * @param alumno: Datos del alumno que se desea dar de alta
	 * @return Un mensaje informativo con el resultado de la operación
	 */
	
	@Override
	public boolean altaAlumno(Alumno alumno) {
		try {
			dao.save(alumno);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Este método modifica el nombre y apellidos de un alumno
	 * 
	 * @param dni: Dni del alumno a modificar
	 * @param nombre: Nombre del alumno modificado
	 * @param apellido1: Primer apellido del alumno modificado
	 * @param apellido2: Segundo apellido del alumno modificado
	 * @return Un mensaje informativo con el resultado de la operación
	 */

	@Override
	public boolean modificarNombreAlumno(String dni, String nombre, String apellido1, String apellido2) {
		try {
			Alumno alumno = dao.findById(dni).orElse(null);
			alumno.setNombre(nombre);
			alumno.setApellido1(apellido1);
			alumno.setApellido2(apellido2);
			dao.save(alumno);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Este método elimina un alumno cuyo dni se pasa como parametro
	 * 
	 * @param dni: Dni del alumno a eliminar
	 * @return Un mensaje informativo con el resultado de la operación
	 */

	@Override
	public boolean eliminarAlumno(String dni) {	
		try {
			Alumno alumno = dao.findById(dni).orElse(null);
			dao.delete(alumno);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Este método obtiene una lista con todos los alumnos
	 * 
	 * @return Una lista con todos los alumnos
	 */

	@Override
	public List<Alumno> obtenerListaAlumnos() {
		return dao.findAll();
	}
	
	/**
	 * Este método obtiene una lista con las asignaturas en las que se encuentra matriculado un alumno cuyo dni se pasa como parametro
	 * 
	 * @param dni: Dni del alumno
	 * @return Una lista con las asignaturas en las que se encuentra matriculado el alumno
	 */

	@Override
	public List<String> obtenerListaAsignaturasAlumno(String dni) {	
		List<String> lista_id_asignaturas_alumno = dao.findIdAsignaturasDNI(dni);
		
		List<String> lista_asignaturas_alumno = new ArrayList<>();
		
		for (String id_asignatura:lista_id_asignaturas_alumno) {
			lista_asignaturas_alumno.add(template.getForObject(url_asignaturas + "/" + id_asignatura + "/nombre", String.class));
		}
		
		return lista_asignaturas_alumno;
	}
	
	/**
	 * Este método obtiene una lista con las notas de un alumno cuyo dni se pasa como parametro
	 *  
	 * @param dni: Dni del alumno
	 * @return Una lista con las notas del alumno
	 */

	@Override
	public List<String> obtenerListaNotasAlumno(String dni) {	
		return Arrays.asList(template.getForObject(url_notas + "/" + dni, String[].class)); //Esta lista debe incluir el nombre de la asignatura 
	}
	
	/**
	 * Este método obtiene una lista con las notas de un alumno cuyo dni se pasa como parametro en una determianda asignatura cuyo nombre se pasa como parametro. 
	 * Esta lista inluye un apartado final donde se muestra la nota media del alumno en dicha asignatura.
	 * 
	 * @param dni: Dni del alumno
	 * @param nombre_asignatura: Nombre de la asignatura
	 * @return Una lista con las notas del alumno en la asignatura junto con la nota media del alumno en la asignatura
	 */

	@Override
	public List<String> obtenerNotaMediaAlumnoAsignatura(String dni, String nombre_asignatura) {
		int id_asignatura = template.getForObject(url_asignaturas + "/" + nombre_asignatura + "/id", int.class);
		int total_temas_asignatura = template.getForObject(url_asignaturas + "/" + nombre_asignatura + "/temas", int.class);
		
		List<String> lista_notas_alumno_asignatura = new ArrayList<String>(Arrays.asList(template.getForObject(url_notas + "/" + dni + "/" + id_asignatura, String[].class)));
		
		float media_nota_asignatura = 0;
		
		for (int i = 0; i < lista_notas_alumno_asignatura.size(); i++) {
			String[] temp = lista_notas_alumno_asignatura.get(i).split(",");
			String[] intervalo_num_temas = temp[0].split("-");
			int num_temas = Integer.parseInt(intervalo_num_temas[1]) - Integer.parseInt(intervalo_num_temas[0]) + 1;
			media_nota_asignatura = media_nota_asignatura + (Float.parseFloat(temp[1]) * ((float) num_temas / (float) total_temas_asignatura));
		}

		if (!lista_notas_alumno_asignatura.isEmpty()) {
			lista_notas_alumno_asignatura.add("Nota media de la asignatura " + nombre_asignatura + " : " + media_nota_asignatura);
		}

		return lista_notas_alumno_asignatura;
	}
	
	/**
	 * Este método matricula al alumno cuyo se pasa como parametro en la asignatura cuyo nombre se pasa como parametro
	 *  
	 * @param dni: Dni del alumno
	 * @param nombre_asignatura: Nombre de la asignatura
	 * @return Un mensaje informativo con el resultado de la operación
	 */

	@Override
	public boolean matricularAlumnoAsignatura(String dni, String nombre_asignatura) {
		int id_asignatura = template.getForObject(url_asignaturas + "/" + nombre_asignatura + "/id", int.class);
		
		AlumnoAsignaturaKey aak = new AlumnoAsignaturaKey(dni, id_asignatura);
		AlumnoAsignatura aa = new AlumnoAsignatura(aak);
		
		try {
			daoAA.save(aa);
		} catch (Exception e) {
			return false;
		}
		
		template.put(url_asignaturas + "/" + id_asignatura + "/+", aa);
		
		return true;
	}

	/**
	 * Este método desmatricula al alumno cuyo se pasa como parametro en la asignatura cuyo nombre se pasa como parametro
	 *  
	 * @param dni: Dni del alumno
	 * @param nombre_asignatura: Nombre de la asignatura
	 * @return Un mensaje informativo con el resultado de la operación
	 */
	
	@Override
	public boolean desmatricularAlumnoAsignatura(String dni, String nombre_asignatura) {
		int id_asignatura = template.getForObject(url_asignaturas + "/" + nombre_asignatura + "/id", int.class);
		
		AlumnoAsignaturaKey aak = new AlumnoAsignaturaKey(dni, id_asignatura);
		
		try {
			AlumnoAsignatura aa = daoAA.findById(aak).orElse(null);
			daoAA.delete(aa);
			template.put(url_asignaturas + "/" + id_asignatura + "/-", aa);
		} catch (Exception e) {
			return false;
		}	
		return true;
	}
}
