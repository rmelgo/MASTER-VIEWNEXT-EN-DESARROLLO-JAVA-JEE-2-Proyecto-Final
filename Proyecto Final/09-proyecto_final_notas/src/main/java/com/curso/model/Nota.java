package com.curso.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Clase Nota
 *
 * Contiene informacion sobre las notas
 *
 * @author Raúl Melgosa
 * @version 1.0
 */

@Entity
@Table(name="notas")
public class Nota {

    /**
     * La clave primaria de la entidad.
     */
	
	@EmbeddedId
    NotaKey id;

    /**
     * La nota obtenida.
     */
	
	private float nota;
	
	/**
     * Crea una nueva instancia de la clase Nota.
     */
	
	public Nota() {
		super();
	}

    /**
     * Crea una nueva instancia de la clase Nota.
     *
     * @param id La clave primaria de la entidad.
     * @param nota La nota obtenida.
     */
	
	public Nota(NotaKey id, float nota) {
		super();
		this.id = id;
		this.nota = nota;
	}

   /**
    * Devuelve la clave primaria de la entidad.
    *
    * @return La clave primaria de la entidad.
    */
	
   public NotaKey getId() {
       return id;
   }

   /**
    * Establece la clave primaria de la entidad.
    *
    * @param id La nueva clave primaria de la entidad.
    */
	
   public void setId(NotaKey id) {
       this.id = id;
   }

   /**
    * Devuelve la nota obtenida.
    *
    * @return La nota obtenida.
    */
   
   public float getNota() {
       return nota;
   }

   /**
    * Establece la nota obtenida.
    *
    * @param nota La nueva nota obtenida.
    */
   
   public void setNota(float nota) {
       this.nota = nota;
   }
}
