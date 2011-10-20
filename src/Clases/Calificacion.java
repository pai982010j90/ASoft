package Clases;

import Humanos.*;

public class Calificacion {

	private float nota;
	private String comentario;
	Alumno evaluado;
	Examen seExamina;

	/**
	 * 
	 * @param examen
	 * @param alumno
	 * @param nota
	 * @param comentario
	 */
	public Calificacion(Examen examen, Alumno alumno, float nota, String comentario) {
		seExamina = examen;
                evaluado = alumno;
                this.nota = nota;
                this.comentario = comentario;
	}

}