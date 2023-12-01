package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.dao.NotaDao;
import com.curso.model.Nota;
import com.curso.model.NotaKey;

/**
 * Clase NotaServiceImpl
 *
 * Servicio del microservicio de Nota
 *
 * @author Raúl Melgosa
 * @version 1.0
 */

@Service
public class NotaServiceImpl implements NotaService {

	@Autowired
	NotaDao dao;
	
	@Autowired
	RestTemplate template;
	
	String url_asignaturas = "http://localhost:7070/asignaturas";
	
	/**
	 * Este método añade una nota cuyos datos se proporcionan como parámetro
	 *  
	 * @param nota: Datos de la nota que se desea añadir
	 * @return Un mensaje informativo con el resultado de la operación
	 */
	
	@Override
	public boolean añadirNota(Nota nota) {
		try {
			dao.save(nota);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Este método modifica el valor numerico de una nota la cual se recibe como parametro. 
	 * Tambien se recibe como parametro el dni del alumno, el id de la asignatura y los temas de la nota a modificar
	 * 
	 * @param dni_alumno: Dni del alumno cuya nota se desea modificar
	 * @param id_asignatura: ID de la asignatura cuya nota se desea modificar
	 * @param temas: Temas de la nota que se desea modificar
	 * @param nota: Valor numerico de la nueva nota
	 * @return Un mensaje informativo con el resultado de la operación
	 */

	@Override
	public boolean modificarValorNota(String dni, int id_asignatura, String temas, float nota) {
		NotaKey notakey = new NotaKey(dni, id_asignatura, temas);
		Nota n = dao.findById(notakey).orElse(null);
		
		if (n == null) {
			return false;
		}
		
		n.setNota(nota);
		
		try {
			dao.save(n);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Este método elimina un nota donde se recibe como parametro el dni del alumno, el id de la asignatura y los temas de la nota a eliminar
	 *  
	 * @param dni_alumno: Dni del alumno cuya nota se desea eliminar
	 * @param id_asignatura: ID de la asignatura cuya nota se desea eliminar
	 * @param temas: Temas de la nota que se desea eliminar
	 * @return Un mensaje informativo con el resultado de la operación
	 */

	@Override
	public boolean eliminarNota(String dni, int id_asignatura, String temas) {
		NotaKey notakey = new NotaKey(dni, id_asignatura, temas);
		Nota n = dao.findById(notakey).orElse(null);
		
		try {
			dao.delete(n);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Este método obtiene una lista de las notas del alumno cuyo dni se pasa como parametro
	 * 
	 * @param dni_alumno: Dni del alumno 
	 * @return Una lista con las notas del alumno
	 */

	@Override
	public List<String> obtenerNotasDNI(String dni) {
		List<String> listado_notas_dni = dao.findAllByDNI(dni);
		
		for (int i = 0; i < listado_notas_dni.size(); i++) {
			String[] campos = listado_notas_dni.get(i).split(",");
			String nombre_asignatura = template.getForObject(url_asignaturas + "/" + campos[0] + "/nombre", String.class);
			
			String resultado = nombre_asignatura + "," + campos[1] + "," + campos[2];
			
			listado_notas_dni.set(i, resultado);
		}
		
		return listado_notas_dni;
	}
	
	/**
	 * Este método obtiene una lista de las notas del alumno cuyo dni se pasa como parametro en una asignatura cuyo ID se pasa como parametro
	 * 
	 * @param dni_alumno: Dni del alumno 
	 * @param id_asignatura: Id de la asignatura
	 * @return Una lista con las notas del alumno en la asignatura correspondiente
	 */

	@Override
	public List<String> obtenerNotasDNIAsignatura(String dni, int id_asignatura) {
		return dao.findAllByDNIAsignatura(dni, id_asignatura);
	}
}
