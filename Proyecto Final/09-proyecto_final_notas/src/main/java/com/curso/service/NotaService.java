package com.curso.service;

import java.util.List;

import com.curso.model.Nota;

/**
 * Interfaz NotaService
 *
 * Interfaz que proporciona los metodos que seran implementados por la clase NotaServiceImpl
 *
 * @author Raúl Melgosa
 * @version 1.0
 */

public interface NotaService {
	public boolean añadirNota(Nota nota);
	public boolean modificarValorNota(String dni, int id_asignatura, String temas, float nota);
	public boolean eliminarNota(String dni, int id_asignatura, String temas);
	public List<String> obtenerNotasDNI(String dni);
	public List<String> obtenerNotasDNIAsignatura(String dni, int id_asignatura);
}
