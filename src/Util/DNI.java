package Util;

import java.io.Serializable;

public class DNI implements Comparable, Serializable{

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DNI other = (DNI) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.numero;
        return hash;
    }
    private int numero;
    private char letra;

    public int getNumero() {
        return numero;
    }

    public char getLetra() {
        return this.letra;
    }

    /**
     * 
     * @param dni
     * @param letra
     */
    public DNI(int numero, char letra) throws DNINoValidoException, IllegalArgumentException {

        /* Ejemplo de asercion. Se ejecuta si, y solo si:
         *  - numero > 101 == false
         *  - la opcion '-ea' esta activada para ejecucion
         * Cuando se lanza la asercion, el programa genera:
         *  - una excepcion de tipo 'AssertionError'
         *  - y si ha puesto un segundo operador despues de ':' el valor como String especificado
         * 
         */

        //assert (numero > 101) : "Parace que esta introduciendo un miembre de la familia real";
        assert (numero > 101);

        if (!isNumeroValido(numero)) {
            throw new IllegalArgumentException("El numero '" + numero + "' no es valido. Debe estar en el rango 0 - 99.999.999.");
        }

        char letraCalculada;
        letraCalculada = calcularLetra(numero);

        // Si la letra es valida con el numero
        char letraUpCase = Character.toUpperCase(letra);
        if (letraCalculada == letraUpCase) {
            this.numero = numero;
            this.letra = letraUpCase;
        } else {
            throw new DNINoValidoException(
                    "El numero '" + numero + "' no cocuerda con la letra '" + letra + "'");
        }
    }

    /**
     * 
     * @param dni
     */
    public static char calcularLetra(int numeroDni) {

        if (isNumeroValido(numeroDni)) {
            String letras = "TRWAGMYFPDXBNJZSQVHLCKET";
            int posicionLetra = numeroDni % 23;
            return letras.charAt(posicionLetra);
        } else {
            throw new IllegalArgumentException(
                    "El numero '" + numeroDni + "' no es valido. Debe estar en el rango 0 - 99.999.999.");
        }
    }

    public static boolean isNumeroValido(int numeroDni) {
        // Este metodo devuelve true o false respectivamente dependiendo de si el
        // numero del dni esta o no dentro del rango permitido
        // Esto se puede implementar con un esquema if-else tipico
        /*
        if (numeroDni < 1 || numeroDni > 99999999) {
        return false;
        } else {
        return true;
        }*/

        /* Pero tambien se puede implementar con un operador ternario
         * Sintaxis del operador ternario:
         * algunaVariable=(condición que devuelve un valor booleano) ? (valor si devuelve true) : (valor si devuelve false)
         * 
         * Por tanto podriamos poner lo siguiente:
         * boolean resultado = (numeroDni < 1 || numeroDni > 99999999)?false:true;
         * return resultado;
         * 
         * Pero tambien podemos hacerlo en un solo paso como sigue:
         */
        //
        return (numeroDni > 0 && numeroDni <= 99999999) ? true : false;


    }

    @Override
    public String toString() {
        return numero + "-" + letra;
    }

    @Override
    public int compareTo(Object o) {
        // Verifico si se puede comparar
        if (o == null || !(this.getClass().getName().equals(o.getClass().getName()))) {
            throw new IllegalArgumentException();
        }
        
        DNI d = (DNI) o;
        if (numero == d.getNumero()) {
            return 0;
        }
/*
        if (numero < d.getNumero()) {
            return -1;
        } else {
            return 1;
        }*/
        return (numero < d.getNumero())?-1:1;
    }
}