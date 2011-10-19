package Humanos;

import Util.DNI;
import Clases.*;

public class Alumno extends Persona {

    public Alumno(DNI dni, String nombre, String apellidos) {
        super(dni,nombre, apellidos);
    }
    @Override
    public String toString() {
        return "Alumno{"+super.toString()+"}";
    }

	private Curso cursa;    

}