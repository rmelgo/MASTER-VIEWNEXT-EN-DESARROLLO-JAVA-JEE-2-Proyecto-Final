package com.curso.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Clase AlumnoAsignatura
 *
 * Contiene informacion sobre las asignaturas a las que estan matriculados los alumnos
 *
 * @author Raúl Melgosa
 * @version 1.0
 */

@Entity
@Table(name="alumnos_asignaturas")
public class AlumnoAsignatura {

    /**
     * La clave primaria de la entidad.
     */
	
    @EmbeddedId
    AlumnoAsignaturaKey id;
		   
    /**
     * Crea una nueva instancia de la clase AlumnoAsignatura.
     */
    
	public AlumnoAsignatura() {
		super();
	}

	/**
     * Crea una nueva instancia de la clase AlumnoAsignatura.
     *
     * @param id La clave primaria de la entidad.
     */
	
	public AlumnoAsignatura(AlumnoAsignaturaKey id) {
		super();
		this.id = id;
	}

    /**
     * Devuelve la clave primaria de la entidad.
     *
     * @return La clave primaria de la entidad.
     */
	
	public AlumnoAsignaturaKey getId() {
		return id;
	}
	
    /**
     * Establece la clave primaria de la entidad.
     *
     * @param id La nueva clave primaria de la entidad.
     */

	public void setId(AlumnoAsignaturaKey id) {
		this.id = id;
	}
}
