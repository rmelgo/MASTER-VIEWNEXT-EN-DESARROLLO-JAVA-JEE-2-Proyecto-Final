package com.curso.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * Clase AlumnoAsignaturaKey
 *
 * Clave primaria de la clase AlumnoAsignatura
 *
 * @author Raúl Melgosa
 * @version 1.0
 */

@Embeddable
public class AlumnoAsignaturaKey implements Serializable {
	
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
     * Crea una nueva instancia de la clase AlumnoAsignaturaKey.
     */
	
	public AlumnoAsignaturaKey() {
		super();
	}

	/**
     * Crea una nueva instancia de la clase AlumnoAsignaturaKey.
     *
     * @param dniAlumno El DNI del alumno.
     * @param idAsignatura El ID de la asignatura.
     */
	
	public AlumnoAsignaturaKey(String dni_alumno, int asignatura_id) {
		super();
		this.dniAlumno = dni_alumno;
		this.idAsignatura = asignatura_id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
