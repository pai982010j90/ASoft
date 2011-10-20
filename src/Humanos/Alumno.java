package Humanos;

import Util.DNI;
import Clases.*;

public class Alumno extends Persona {

    private Curso cursa;

    public Alumno(DNI dni, String nombre, String apellidos) {
        super(dni, nombre, apellidos);
    }

    @Override
    public String toString() {
        return "Alumno{" + super.toString() + "}";
    }
    
    public void setCursa(Curso cursa){
        this.cursa = cursa;
    }
    
    public Curso getCursa(){
        return cursa;
    }    
}