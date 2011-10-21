
import Clases.Calificacion;
import Clases.Curso;
import Clases.Examen;
import Humanos.Alumno;
import Humanos.CompDNIPersona;
import Humanos.Profesor;
import Util.DNI;
import Util.DNINoValidoException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;
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

            Curso cursoPAI = new Curso("Programador de Aplicaciones Informáticas",
                    new Date(2011, 2, 28), (short) 975, profe1);

            System.out.println(cursoPAI);
            System.out.println("Profesor:" + cursoPAI.getImpartidoPor());


            //Creamos alumnos
            Alumno alumno1 = new Alumno(new DNI(60000001, 'q'), "Pilar", "Carrasco");
            Alumno alumno2 = new Alumno(new DNI(60000000, 's'), "Ignacio", "Xonzález");
            Alumno alumno3 = new Alumno(new DNI(60000002, 'v'), "Vanesa", "Galvez");
            Alumno alumno31 = new Alumno(new DNI(12345678, 'z'), "Ignacio1", "Ñonzalez");
            // Creamos un nuevo alumno repetido (dni ya existe, aunque el nombre es !=)
            Alumno alumno4 = new Alumno(new DNI(60000002, 'v'), "V", "Gálvez");

            // Matriculamos
            cursoPAI.matricularAlumno(alumno1);
            cursoPAI.matricularAlumno(alumno2);
            cursoPAI.matricularAlumno(alumno3);
            cursoPAI.matricularAlumno(alumno31);

            System.out.println(cursoPAI.getImpartidoA().size());
            
            Collection matriculados = cursoPAI.getImpartidoA();
            
            // Imprimo la relacion de alumnos matriculados segun criterio natural
            System.err.println("xxx"+matriculados);
            
            // Crea una nueva coleccion ordenada por un criterio NO natural
            Collection matriculadosOrdenDNI = new TreeSet(new CompDNIPersona());
            
            for(Iterator i = matriculados.iterator();i.hasNext(); ){
                matriculadosOrdenDNI.add(i.next());
            }
            
            System.err.println("Por DNI"+matriculadosOrdenDNI);
            
            
            //Imprimo la relacion de alumnos matriculados segun criterio CompDNIPersona

            cursoPAI.matricularAlumno(alumno4);

            Examen examenPAI1 = new Examen("HTML", new Date(2011, 3, 2));
            Examen examenPAI2 = new Examen("CSS", new Date(2011, 3, 3));
            cursoPAI.convocarExamen(examenPAI1);
            cursoPAI.convocarExamen(examenPAI2);


            Calificacion calificaAlumno1Examen1 = new Calificacion(examenPAI1, alumno1, 10.0f, "GENIAL!!!");
            examenPAI1.agregaCalificacion(calificaAlumno1Examen1);
            alumno1.agregaCalificacion(calificaAlumno1Examen1);




            System.out.println(cursoPAI.getImpartidoA().size());
        } catch (DNINoValidoException ex) {
            Logger.getLogger(AcademiaSoft.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(AcademiaSoft.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}