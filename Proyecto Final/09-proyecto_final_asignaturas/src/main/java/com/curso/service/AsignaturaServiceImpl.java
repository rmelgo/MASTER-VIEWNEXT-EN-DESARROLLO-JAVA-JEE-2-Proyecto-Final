package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.AsignaturaDao;
import com.curso.model.Asignatura;

/**
 * Clase AsignaturaServiceImpl
 *
 * Servicio del microservicio de Asignatura
 *
 * @author Raúl Melgosa
 * @version 1.0
 */

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

	@Autowired
	AsignaturaDao dao;

	/**
	 * Este método da de alta a una asignatura cuyos datos se proporcionan como parámetro
	 * 
	 * @param asignatura: Datos de la asignatura que se desea dar de alta
	 * @return Un mensaje informativo con el resultado de la operación
	 */
	
	@Override
	public boolean añadirAsignatura(Asignatura asignatura) {
		try {
			dao.save(asignatura);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Este método elimina una asignatura cuyo ID se pasa como parametro
	 * 
	 * @param id_asignatura: ID del asignatura a eliminar
	 * @return Un mensaje informativo con el resultado de la operación
	 */

	@Override
	public boolean eliminarAsignatura(int id_asignatura) {
		try {
			Asignatura asignatura = dao.findById(id_asignatura).orElse(null);
			dao.delete(asignatura);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Este método obtiene los alumnos matriculados a una asignatura cuyo ID se para como parametro
	 * 
	 * @param id_asignatura: ID de la asignatura 
	 * @return Un mensaje informativo con el resultado de la operación
	 */

	@Override
	public int obtenerNumeroAlumnosMatriculadosAsignatura(int id_asignatura) {
		try {
			Asignatura asignatura = dao.findById(id_asignatura).orElse(null);
			return asignatura.getNumAlumnosMatriculados();
		} catch (Exception e) {
			return 0;
		}
	}
	
	/**
	 * Este método obtiene una lista con todas las asignaturas
	 * 
	 * @return Una lista con todas las asignaturas
	 */

	@Override
	public List<Asignatura> obtenerListaAsignatura() {
		return dao.findAll();
	}
	
	/**
	 * Este método modifica el numero de alumnos matriculados en una asignatura cuyo ID se pasa como parametro
	 *
	 * @param id_asignatura: ID de la asignatura 
	 * @param tipo_operacion: + si es un incremento y - si es un decremento
	 * @return Un mensaje informativo con el resultado de la operación
	 */

	@Override
	public boolean modificarAlumnosMatriculadosAsignatura(int id_asignatura, String operacion) {
		try {
			Asignatura asignatura = dao.findById(id_asignatura).orElse(null);
			if (operacion.equals("+")) {
				asignatura.setNumAlumnosMatriculados(asignatura.getNumAlumnosMatriculados() + 1);
			}
			if (operacion.equals("-")) {
				asignatura.setNumAlumnosMatriculados(asignatura.getNumAlumnosMatriculados() - 1);
			}
			dao.save(asignatura);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Este método obtiene el nombre de una asignatura cuyo ID se pasa como parametro
	 * 
	 * @param id_asignatura: ID de la asignatura
	 * @return El nombre de la asignatura
	 */

	@Override
	public String obtenerNombreAsignatura(int id_asignatura) {
		return dao.obtenerAsignaturaID(id_asignatura);
	}
	
	/**
	 * Este método obtiene el ID de una asignatura cuyo nombre se pasa como parametro
	 * 
	 * @param nombre_asignatura: Nombre de la asignatura
	 * @return El ID de la asignatura
	 */
	
	@Override
	public int obtenerIdAsignatura(String nombre_asignatura) {
		String id_asignatura = dao.obtenerAsignaturaNombre(nombre_asignatura);
		if (id_asignatura != null) {
			return Integer.parseInt(id_asignatura);
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Este método obtiene el numero de temas de una asignatura cuyo nombre se pasa como parametro
	 * 
	 * @param nombre_asignatura: Nombre de la asignatura
	 * @return El numero de la asignatura
	 */

	@Override
	public int obtenerTemasAsignatura(String nombre_asignatura) {
		String temas_asignatura = dao.obtenerTemasAsignatura(nombre_asignatura);
		if (temas_asignatura != null) {
			return Integer.parseInt(temas_asignatura);
		}
		else {
			return 0;
		}	
	}
}
