package com.curso.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase Alumno
 *
 * Contiene informacion sobre los alumnos
 *
 * @author Raúl Melgosa
 * @version 1.0
 */

@Entity
@Table(name="alumnos")
public class Alumno {

	/**
     * El DNI del alumno.
     */
	@Id
	private String dni;
	
    /**
     * El nombre del alumno.
     */
	
	private String nombre;
	
    /**
     * El primer apellido del alumno.
     */
	
	private String apellido1;
	
    /**
     * El segundo apellido del alumno.
     */
	
	private String apellido2;
	
    /**
     * La dirección del alumno.
     */
	
	private String direccion;
	
    /**
     * La fecha de nacimiento del alumno.
     */
	
	private LocalDate fechaNacimiento;
	
    //@OneToMany(mappedBy = "alumno")
    //List<AlumnoAsignatura> alumnoAsignatura;
	
	/**
     * Crea una nueva instancia de la clase Alumno.
     */
	
	public Alumno() {
		super();
	}
	
	/**
     * Crea una nueva instancia de la clase Alumno.
     *
     * @param dni El DNI del alumno.
     * @param nombre El nombre del alumno.
     * @param apellido1 El primer apellido del alumno.
     * @param apellido2 El segundo apellido del alumno.
     * @param direccion La dirección del alumno.
     * @param fechaNacimiento La fecha de nacimiento del alumno.
     */

	public Alumno(String dni, String nombre, String apellido1, String apellido2, String direccion,
			LocalDate fechaNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
     * Devuelve el DNI del alumno.
     *
     * @return El DNI del alumno.
     */
	
    public String getDni() {
        return dni;
    }

    /**
     * Establece el DNI del alumno.
     *
     * @param dni El nuevo DNI del alumno.
     */
    
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Devuelve el nombre del alumno.
     *
     * @return El nombre del alumno.
     */
    
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del alumno.
     *
     * @param nombre El nuevo nombre del alumno.
     */
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el primer apellido del alumno.
     *
     * @return El primer apellido del alumno.
     */
    
    public String getApellido1() {
        return apellido1;
    }

    /**
     * Establece el primer apellido del alumno.
     *
     * @param apellido1 El nuevo primer apellido del alumno.
     */
    
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * Devuelve el segundo apellido del alumno.
     *
     * @return El segundo apellido del alumno.
     */
    
    public String getApellido2() {
        return apellido2;
    }

    /**
     * Establece el segundo apellido del alumno.
     *
     * @param apellido2 El nuevo segundo apellido del alumno.
     */
    
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    /**
     * Devuelve la dirección del alumno.
     *
     * @return La dirección del alumno.
     */
    
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del alumno.
     *
     * @param direccion La nueva dirección del alumno.
     */
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve la fecha de nacimiento del alumno.
     *
     * @return La fecha de nacimiento del alumno.
     */
    
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del alumno.
     *
     * @param fechaNacimiento La nueva fecha de nacimiento del alumno.
     */
    
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }		
}
