package Clases;

import Humanos.*;

public class Calificacion implements Comparable{

	private float nota;

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
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

    @Override
    public int compareTo(Object o) {
        // Verificion si puede comparar
        if (o == null || this.getClass().getName() != o.getClass().getName()) {
            throw new IllegalArgumentException();
        }

        Calificacion c = (Calificacion) o;
        if(nota==c.getNota()) return 0;
        return nota<c.getNota()?-1:1;
        
    }
}