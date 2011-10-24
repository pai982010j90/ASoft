package UI;

import java.util.*;
import java.io.*;

public class Menu {

    Map<String, String> opciones;

    public Menu() {
        opciones = new TreeMap<String, String>();
        opciones.put("0", "Salir");
        opciones.put("1", "Mostrar Todo");
        opciones.put("2", "Serializar Curso");
        opciones.put("3", "Deserializar Curso");
        opciones.put("4", "Inicializacion interna");
        opciones.put("5", "Mostrar Alumno");
    }

    public int getOpcion() {
        String opcion = null;
        boolean pedirOpcion = false;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            do {
                opcion = br.readLine();
                if(opcion != null && !(opciones.containsKey(opcion))){
                    System.out.print("Opción Incorrecta... ");
                    mostrarSelectorOpcion();
                    pedirOpcion = true;
                }
                else break;
                
            } while (opcion == null || pedirOpcion == true);
        } catch (IOException e) {
            System.err.println("Fallo en la lectura desde teclado");
        }
        return new Integer(opcion).intValue();
    }

    public void mostrarOpciones() {
        System.out.println("M E N U");
        Set<String> itemOpcion = opciones.keySet();

        for (String clave : itemOpcion) {
            System.out.println(clave + " - " + opciones.get(clave));
        }

    }

    public void mostrarSelectorOpcion() {

        //Set<String> itemOpciones = opciones.keySet();
        TreeSet<String> itemOpciones = new TreeSet(opciones.keySet());
        String cadOpciones = "";
        for (String itemOpcion : itemOpciones) {
            cadOpciones += itemOpcion;
        }

        System.out.print("Elija opción (" + cadOpciones + "):");
    }
}