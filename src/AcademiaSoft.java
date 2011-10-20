import Clases.Curso;
import Clases.Examen;
import Humanos.Alumno;
import Humanos.Profesor;
import Util.DNI;
import Util.DNINoValidoException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nanohp
 */
public class AcademiaSoft {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Profesor profe1;
            profe1 = new Profesor(new DNI(12345678, 'z'), "Francisco", "Pérez");

            Curso curso = new Curso("Programador de Aplicaciones Informáticas",
                    new Date(2011, 2, 28), (short) 975, profe1);

            System.out.println(curso);
            System.out.println("Profesor:" + curso.getImpartidoPor());


            //Creamos alumnos
            Alumno alumno1 = new Alumno(new DNI(60000001, 'q'), "Pilar", "Carrasco");
            Alumno alumno2 = new Alumno(new DNI(60000000, 's'), "Ignacio", "González");
            Alumno alumno3 = new Alumno(new DNI(60000002, 'v'), "Vanesa", "Gálvez");
            // Creamos un nuevo alumno repetido (dni ya existe, aunque el nombre es !=)
            Alumno alumno4 = new Alumno(new DNI(60000002, 'v'), "V", "Gálvez");

            // Matriculamos
            curso.matricularAlumno(alumno1);
            curso.matricularAlumno(alumno2);
            curso.matricularAlumno(alumno3);

            System.out.println(curso.getImpartidoA().size());
            System.out.println(curso.getImpartidoA());

            curso.matricularAlumno(alumno4);
            
            Examen examen1 = new Examen("HTML", new Date(2011,3,2));
            curso.convocarExamen(examen1);
            
            System.out.println(curso.getImpartidoA().size());
        } catch (DNINoValidoException ex) {
            Logger.getLogger(AcademiaSoft.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(AcademiaSoft.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}