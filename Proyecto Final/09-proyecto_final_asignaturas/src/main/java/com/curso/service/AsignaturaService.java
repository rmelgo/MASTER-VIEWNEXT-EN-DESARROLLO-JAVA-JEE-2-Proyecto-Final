package com.curso.service;

import java.util.List;

import com.curso.model.Asignatura;

/**
 * Interfaz AsignaturaService
 *
 * Interfaz que proporciona los metodos que seran implementados por la clase AsignaturaServiceImpl
 *
 * @author Raúl Melgosa
 * @version 1.0
 */

public interface AsignaturaService {
	public boolean añadirAsignatura(Asignatura asignatura);
	public boolean eliminarAsignatura(int id_asignatura);
	public int obtenerNumeroAlumnosMatriculadosAsignatura(int id_asignatura);
	public List<Asignatura> obtenerListaAsignatura();
	public boolean modificarAlumnosMatriculadosAsignatura(int id_asignatura, String operacion);
	public String obtenerNombreAsignatura(int id_asignatura);
	public int obtenerIdAsignatura(String nombre_asignatura);
	public int obtenerTemasAsignatura(String nombre_asignatura);
}
