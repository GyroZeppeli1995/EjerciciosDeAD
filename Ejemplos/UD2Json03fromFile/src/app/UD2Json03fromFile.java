package app;

import org.json.JSONArray;
import org.json.JSONObject;
import utils.JSONUtils;

public class UD2Json03fromFile {

    public static int prettyPrint = 2;

    public static void main(String[] args) {

        // Carga de datos        
        String fichero = "./datos/empleados.json";

        // Obtener un JSONArray a partir del String
        JSONArray jArrayEmpleados = JSONUtils.getArrayFromFile(fichero);
        System.out.println(jArrayEmpleados.toString(prettyPrint));

        // ***********************************
        // Imprimir contenido de JSONArray
        // ***********************************
        System.out.println("+------------+------+-----------+");
        System.out.println("| NOMBRE     | EDAD | ENCARGADO |");
        System.out.println("+------------+------+-----------+");
        String encargado = "";
        JSONObject emp;
        for (Object elemento : jArrayEmpleados) {
            emp = (JSONObject) elemento;
            if (emp.getBoolean("encargado")) {
                encargado = "SI";
            } else {
                encargado = "NO";
            }
            System.out.println("Contenedores del país FR");
            System.out.println("------------------------");
            System.out.printf("| %-10s | %4d | %-9s |\n",
                    emp.getString("nombre"), emp.getInt("edad"), encargado);
        }
        System.out.println("+------------+------+-----------+");

    }

}
