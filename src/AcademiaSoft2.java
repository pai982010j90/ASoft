
import Clases.*;
import Humanos.*;
import Util.*;
import java.util.*;
import UI.*;
import java.io.*;

public class AcademiaSoft2 {

    public static void main(String[] args) throws Exception {
        Curso cursoPAI = inicializaDatosPrueba();
        CursoVista cursoVista = new CursoVista(cursoPAI);
        int opcion = -1;

        Menu menu = new Menu();
        do {
            menu.mostrarItems();
            menu.mostrarSelectorOpcion();
            opcion = menu.getOpcion();
            switch (opcion) {
                case 1:
                    cursoVista.mostrarCurso();
                    break;
                case 2:
                    serializarCurso(cursoPAI);
                    break;
                case 3:
                    cursoPAI = deSerializarCurso();
                    break;
                case 4:
                    cursoPAI = inicializaDatosPrueba();
                    break;

                case 5:
                    DialogoCampoVista dcv = new DialogoCampoVista("Que alumno busca?", "DNI - Alumno: ");
                    int numDNIAlumno = Integer.parseInt(dcv.ejecutaVista());
                    Alumno alumno = cursoPAI.getImpartidoA().get(numDNIAlumno);
                    if (alumno != null) {
                        System.out.println(alumno.getNombre());
                    } else {
                        System.out.println("No existe el alumno con DNI:" + numDNIAlumno);
                    }

                    break;

                case 6:
                    AltaPersonaVista avp = new AltaPersonaVista("Alta de Persona", "Alumno");
                    Persona p = new Alumno(avp.ejecutaVista());
                    cursoPAI.matricularAlumno((Alumno) p);

                    break;


                default:
                    assert false : "Opcion de menu no controlada";
            }
        } while (opcion > 0);





    }

    public static Curso inicializaDatosPrueba() throws Exception {
        Profesor profe1 = new Profesor(new DNI(12345678, 'z'), "Francisco", "Pérez");

        Curso cursoPAI = new Curso("Programador de Aplicaciones Informáticas",
                new Date(2011, 2, 28), (short) 975, profe1);

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

        Examen examenPAI1 = new Examen("HTML", new Date(2011, 3, 2));
        Examen examenPAI2 = new Examen("CSS", new Date(2011, 3, 3));
        cursoPAI.convocarExamen(examenPAI1);
        cursoPAI.convocarExamen(examenPAI2);

        Calificacion cPAI1HTMLa1 = new Calificacion(examenPAI1, alumno1, 10, "Perfecto");
        Calificacion cPAI1HTMLa2 = new Calificacion(examenPAI1, alumno2, 9, "Muy bien, pero se que puede hacerlo mejor");
        Calificacion cPAI1HTMLa3 = new Calificacion(examenPAI1, alumno3, 7.5f, "Puede hacerlo mucho mejor");
        examenPAI1.agregaCalificacion(cPAI1HTMLa1);
        examenPAI1.agregaCalificacion(cPAI1HTMLa2);
        examenPAI1.agregaCalificacion(cPAI1HTMLa2);

        return cursoPAI;
    }

    public static void serializarCurso(Curso curso) throws Exception {
        FileOutputStream fos = new FileOutputStream("asoft.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(curso);
        oos.close();
    }

    public static Curso deSerializarCurso() throws Exception {
        Curso curso = null;

        FileInputStream fis = new FileInputStream("asoft.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        curso = (Curso) ois.readObject();
        ois.close();

        return curso;
    }
}
