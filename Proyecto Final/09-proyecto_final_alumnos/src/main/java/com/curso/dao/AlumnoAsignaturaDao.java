package com.curso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.AlumnoAsignatura;
import com.curso.model.AlumnoAsignaturaKey;

/**
 * Interfaz AlumnoAsignaturaDao
 *
 * Interfaz que proporciona los metodos y querys que seran implementados por la clase AlumnoServiceImpl
 *
 * @author Raúl Melgosa
 * @version 1.0
 */

public interface AlumnoAsignaturaDao extends JpaRepository<AlumnoAsignatura, AlumnoAsignaturaKey> {

}
