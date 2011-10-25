package UI;

import java.util.*;
import java.io.*;

public class Menu {

    private Map<String, String> items;

    public Map<String, String> getItems() {
        return items;
    }

    public Map<String, String> getOpciones() {
        return items;
    }

    public void setItems(Map<String, String> items) {
        this.items = items;
    }

    public Menu() {
        items = new TreeMap<String, String>();
        items.put("0", "Salir");
        items.put("1", "Mostrar Todo");
        items.put("2", "Serializar Curso");
        items.put("3", "Deserializar Curso");
        items.put("4", "Inicializacion interna");
        items.put("5", "Mostrar Alumno");
        items.put("6", "Matricular Alumno");
    }

    public int getOpcion() {
        String opcion = null;
        boolean pedirOpcion = false;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            do {
                opcion = br.readLine();
                if(opcion != null && !(items.containsKey(opcion))){
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

    public void mostrarItems() {
        System.out.println("M E N U");
        Set<String> itemOpcion = items.keySet();

        for (String clave : itemOpcion) {
            System.out.println(clave + " - " + items.get(clave));
        }

    }

    public void mostrarSelectorOpcion() {

        //Set<String> itemOpciones = items.keySet();
        TreeSet<String> itemOpciones = new TreeSet(items.keySet());
        String cadOpciones = "";
        for (String itemOpcion : itemOpciones) {
            cadOpciones += itemOpcion;
        }

        System.out.print("Elija opción (" + cadOpciones + "):");
    }
}