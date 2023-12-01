package com.curso.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * Clase NotaKey
 *
 * Clave primaria de la clase Nota
 *
 * @author Raúl Melgosa
 * @version 1.0
 */

@Embeddable
public class NotaKey implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * El DNI del alumno.
     */
	
	@Column(name = "dni_alumno")
	String dniAlumno;

    /**
     * El ID de la asignatura.
     */
	
	@Column(name = "id_asignatura")
	int idAsignatura;
	
    /**
     * Los tema de la nota.
     */
	
	@Column(name = "temas")
	String temas;
	
	/**
     * Crea una nueva instancia de la clase NotaKey.
     */
	
	public NotaKey() {
		super();
	}
	
    /**
     * Crea una nueva instancia de la clase NotaKey.
     *
     * @param dniAlumno El DNI del alumno.
     * @param idAsignatura El ID de la asignatura.
     * @param tema El tema de la nota.
     */

	public NotaKey(String dniAlumno, int idAsignatura, String temas) {
		super();
		this.dniAlumno = dniAlumno;
		this.idAsignatura = idAsignatura;
		this.temas = temas;
	}

	/**
     * Devuelve el DNI del alumno.
     *
     * @return El DNI del alumno.
     */
	
    public String getDniAlumno() {
        return dniAlumno;
    }

    /**
     * Establece el DNI del alumno.
     *
     * @param dniAlumno El nuevo DNI del alumno.
     */
    
    public void setDniAlumno(String dniAlumno) {
        this.dniAlumno = dniAlumno;
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
     * Devuelve los temas de la nota.
     *
     * @return Los temas de la nota.
     */
    
    public String getTema() {
        return temas;
    }

    /**
     * Establece los temas de la nota.
     *
     * @param temas Los nuevo temas de la nota.
     */
    
    public void setTema(String temas) {
        this.temas = temas;
    }

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
