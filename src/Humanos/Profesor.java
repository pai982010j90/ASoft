package Humanos;

import Clases.Curso;
import Util.DNI;

public class Profesor extends Persona {

    private Curso imparte;

    /**
     * 
     * @param dni
     * @param nombre
     * @param apellidos
     */
    public Profesor(DNI dni, String nombre, String apellidos) {
        super(dni, nombre, apellidos);
    }

    public void setImparte(Curso curso) {
        imparte = curso;
    }

    public Curso getImparte() {
        return imparte;
    }

    @Override
    public String toString() {
        return "Profesor{"+super.toString()+"}";
    }
}