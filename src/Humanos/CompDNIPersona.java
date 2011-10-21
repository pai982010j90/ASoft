/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Humanos;

import java.util.Comparator;

/**
 *
 * @author nanohp
 */
public class CompDNIPersona implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 == null || o2 == null
                || !(o1 instanceof Persona) || !(o2 instanceof Persona)) {
            throw new IllegalArgumentException();
        }
        Persona d1 = (Persona) o1;
        Persona d2 = (Persona) o2;

        return d1.getDni().compareTo(d2.getDni());
        /* Todo lo anterior se puede hacer en un solo paso como sigue
         * return ((Persona)o1).getDni().compareTo(((Persona)o2).getDni());
         */
        

    }
}
