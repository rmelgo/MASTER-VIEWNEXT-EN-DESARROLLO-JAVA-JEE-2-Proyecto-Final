package com.curso.service;

import java.util.List;

import com.curso.model.Alumno;

/**
 * Interfaz AlumnoService
 *
 * Interfaz que proporciona los metodos que seran implementados por la clase AlumnoServiceImpl
 *
 * @author Raúl Melgosa
 * @version 1.0
 */

public interface AlumnoService {
	public boolean altaAlumno(Alumno alumno);
	public boolean modificarNombreAlumno(String dni, String nombre, String apellido1, String apellido2);
	public boolean eliminarAlumno(String dni);
	public List<Alumno> obtenerListaAlumnos();
	public List<String> obtenerListaAsignaturasAlumno(String dni);
	public List<String> obtenerListaNotasAlumno(String dni);
	public List<String> obtenerNotaMediaAlumnoAsignatura(String dni, String nombre_asignatura);
	public boolean matricularAlumnoAsignatura(String dni, String nombre_asignatura);
	public boolean desmatricularAlumnoAsignatura(String dni, String nombre_asignatura);
}
