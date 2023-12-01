package com.curso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase Asignatura
 *
 * Contiene informacion sobre las asignaturas
 *
 * @author Raúl Melgosa
 * @version 1.0
 */

@Entity
@Table(name="asignaturas")
public class Asignatura {

	/**
     * El ID de la asignatura.
     */
	@Id
	private int idAsignatura;
	
	/**
     * El nombre de la asignatura.
     */
	
	private String nombre;
	
    /**
     * El número de temas de la asignatura.
     */
	
	private String numTemas;
	
    /**
     * El número de alumnos matriculados en la asignatura.
     */
	
	private int numAlumnosMatriculados;
	
	/**
     * Crea una nueva instancia de la clase Asignatura.
     */
	
	public Asignatura() {
		super();
	}
	
    /**
     * Crea una nueva instancia de la clase Asignatura.
     *
     * @param idAsignatura El ID de la asignatura.
     * @param nombre El nombre de la asignatura.
     * @param numTemas El número de temas de la asignatura.
     * @param numAlumnosMatriculados El número de alumnos matriculados en la asignatura.
     */
	
	public Asignatura(int idAsignatura, String nombre, String numTemas, int numAlumnosMatriculados) {
		super();
		this.idAsignatura = idAsignatura;
		this.nombre = nombre;
		this.numTemas = numTemas;
		this.numAlumnosMatriculados = numAlumnosMatriculados;
	}

	/**
     * Devuelve el ID de la asignatura.
     *
     * @return El ID de la asignatura.
     */
    public int getIdAsignatura() {
        return idAsignatura;
    }

    /**
     * Establece el ID de la asignatura.
     *
     * @param idAsignatura El nuevo ID de la asignatura.
     */
    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    /**
     * Devuelve el nombre de la asignatura.
     *
     * @return El nombre de la asignatura.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la asignatura.
     *
     * @param nombre El nuevo nombre de la asignatura.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el número de temas de la asignatura.
     *
     * @return El número de temas de la asignatura.
     */
    public String getNumTemas() {
        return numTemas;
    }

    /**
     * Establece el número de temas de la asignatura.
     *
     * @param numTemas El nuevo número de temas de la asignatura.
     */
    public void setNumTemas(String numTemas) {
        this.numTemas = numTemas;
    }

    /**
     * Devuelve el número de alumnos matriculados en la asignatura.
     *
     * @return El número de alumnos matriculados en la asignatura.
     */
    public int getNumAlumnosMatriculados() {
        return numAlumnosMatriculados;
    }

    /**
     * Establece el número de alumnos matriculados en la asignatura.
     *
     * @param numAlumnosMatriculados El nuevo número de alumnos matriculados en la asignatura.
     */
    public void setNumAlumnosMatriculados(int numAlumnosMatriculados) {
        this.numAlumnosMatriculados = numAlumnosMatriculados;
    }
}
