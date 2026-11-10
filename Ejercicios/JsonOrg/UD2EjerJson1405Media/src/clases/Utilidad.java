/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author alumno
 */
public class Utilidad {
    
    public static <T> void escribirJSON(String ruta,List<T> contenido, boolean sobrescribir)
    {
        File fichero = new File(ruta);
        
        JSONArray jsonArray = new JSONArray(contenido);
        
        try (PrintWriter pw = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(fichero, sobrescribir), StandardCharsets.UTF_8)))) 
        {
            jsonArray.write(pw,2,0);
            

        }
        catch (Exception e)
        {
            System.out.println("Ha habido un error al escribir el fichero: " + e.getMessage());
        }
    }
    
    public static void mostrarArrayFiltrado(JSONArray jsonArray, String filtroClave, String filtroValor)
    {
        JSONObject objetoGenerico;

        for (Object elemento : jsonArray) {
            
            
            objetoGenerico = (JSONObject) elemento;
            
            System.out.println("");
            
            if(objetoGenerico.get(filtroClave).equals(filtroValor))
            {
                System.out.printf("IdContenedor:%3d Producto:%-20s País:%-3s Ciudad:%-3s\n",
                    objetoGenerico.getInt("idContenedor"),
                    objetoGenerico.getString("producto"),
                    objetoGenerico.getString("pais"),
                    objetoGenerico.getString("ciudad"));
            }

        }
        
    }
    
    public static void recorrerArrayForClasico(JSONArray jsonArray)
    {
        
        System.out.println("Recorrer el Array de Objetos con FOR y contador");
        System.out.println("-----------------------------------------------");
        
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject item = jsonArray.getJSONObject(i);
            
            System.out.printf("Id:%3d \nNombre:%8s\n",
                    item.optInt("Id"),
                    item.optString("Nombre"));
            System.out.println("");
            
        }
        
        
    }
    
    
    public static void mostrarLista(List<Alumno> alumnos)
    {
        System.out.println("Listado de Alumnos (ArrayList)");
        System.out.println("------------------------------");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(alumnos.get(i).getNombre() + " - " + alumnos.get(i).getLocalidad());
            
        }
    }
    
    public static int calcularCantidadnotas(ArrayList<Double> notas)
    {
        int cantidad = notas.size();
        
        return cantidad;
    }
    
    public static double calcularMedia(ArrayList<Double> notas)
    {
        double cantidad = 0.0;
        
        for (int i = 0; i < notas.size(); i++) {
            cantidad += notas.get(i);
            
        }
        cantidad = Math.round((cantidad / notas.size()) * 100)/100.0;
        
        return cantidad;
    }
    
    public static void crearJSON(List<Alumno> alumnos, String ruta)
    {
        JSONArray jSONArray = new JSONArray();
        
        for (Alumno alumno : alumnos) {
            JSONObject jOBJ = new JSONObject();
            jOBJ.put("numnotas", calcularCantidadnotas(alumno.getNotas()));
            jOBJ.put("notamedia", calcularMedia(alumno.getNotas()));
            jOBJ.put("notas", alumno.getNotas());
            jOBJ.put("localidad", alumno.getLocalidad());
            jOBJ.put("id", alumno.getId());
            jOBJ.put("nombre", alumno.getNombre());
            
            jSONArray.put(jOBJ);
            
            
        }
        
        
        
        //Mostramos como se escribira el JSON
        System.out.println("Alumnos (JSON)");
        System.out.println("--------------");
        System.out.println(jSONArray.toString(2));
        
        try(FileWriter fw = new FileWriter(ruta,false)) {
            System.out.println("Se esta generando el fichero JSON...");
            jSONArray.write(fw,2,0); // 2=prettyPrint, 0=tabulación
            
            
        } catch (Exception e) {
            System.out.println("Error al escribir el JSON: " + e.getMessage());
        }
        
        System.out.println("El fichero se genero correctamente");
        
    }
    
    public static List<Alumno> leerFicheroAlumnos(String ruta) throws IOException {
        List<Alumno> alumnos = new ArrayList<Alumno>();
        
        File archivo = new File(ruta);
        
        //Apertura del fichero y creación de BufferedReader
            try (BufferedReader br
                    = new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream(archivo), StandardCharsets.UTF_8))) {
                
                String linea;
                //Booleano para saltarse la cabecera
                boolean cabeceraSaltada = false;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                    if(cabeceraSaltada != false)
                    {
                        //Esto esta hardcodeado porque conocemos la posicion de todos estos datos en la clase
                        String[] parametros = linea.split("\\|");
                        int id = Integer.valueOf(parametros[0]);
                        String nombre = parametros[1];
                        String localidad = parametros[2];
                        ArrayList<Double> notas = new ArrayList<Double>();
                        //Dado que las notas pueden tener un tamaño dinamico y no sabemos cuantas hay que hacerlo con un for
                        for (int i = 3; i < parametros.length; i++) {
                            notas.add(Double.valueOf(parametros[i]));
                            
                        }
                        Alumno alumno = new Alumno(id,nombre,localidad,notas);
                        alumnos.add(alumno);
                        
                    }
                    else
                    {
                        cabeceraSaltada = true;
                        
                    }
                    
                    

                    
                    
                }
                
            }
            catch(Exception e)
            {
                System.out.println("Error en la lectura del archivo: " + e.getMessage());
            }
        
        
          
        
        return alumnos;
        
    }
    
    public static void mostrarJSONdesdeFichero(String ruta)
    {
        JSONArray jsonArray = getArrayFromFile(ruta);
        
        for (Object elemento : jsonArray) {
            JSONObject jObj = (JSONObject) elemento;
            for (String key: jObj.keySet()) {
                System.out.println(key+":"+jObj.get(key));
            }
            
        }
        
    }
    
    public static void recorrerForElementos(JSONArray jSONArray)
    {
        System.out.println("Recorrer el Array de Objetos con FOR de elementos");
        System.out.println("-----------------------------------------------");
        
        for (Object elemento : jSONArray) {
            //Parseamos el elemento a jsonobject
            JSONObject jObj = (JSONObject) elemento;
            
            System.out.println(elemento);
            System.out.printf("Id:%3d \nNombre:%8s\n",
                    jObj.optInt("Id"),
                    jObj.optString("Nombre"));
            System.out.println("");
            
        }
        
        
    }
    
    public static void recorrerIterator(JSONArray jSONArray)
    {
        System.out.println("Recorrer el Array de Objetos con ITERATOR");
        System.out.println("-----------------------------------------------");
        
        
        for (Iterator iterator = jSONArray.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            JSONObject jObj = (JSONObject) next;
            
            System.out.println(next);
            System.out.printf("Id:%3d \nNombre:%8s\n",
                    jObj.optInt("Id"),
                    jObj.optString("Nombre"));
            System.out.println("");
            
        }
 
    }
    
    public static void accesoDirectoValor(JSONArray jSONArray, String valor, int posicion)
    {
        System.out.println("------------------------------------------");
        try {
            
            JSONObject jObj = jSONArray.getJSONObject(posicion);
            System.out.println("Del elemento con indice: " + posicion + " -> obtener el: " + valor);
            System.out.println(jObj.opt(valor));
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        
    }
    
    //Este metodo es generico y se puede reutilizar
    public static void mostrarJSON(JSONObject jObj)
    {
        Iterator claves = jObj.keys();
        
        System.out.println("------------------------------------------");
        while (claves.hasNext()) {
            String claveString = claves.next().toString();
            System.out.printf("Clave:%4s\nValor:%4s\n", 
                    claveString, 
                    jObj.optString(claveString));
            System.out.println("");
            
            
        }
    }
    
    
    
    
    
    
    
    
    


    // *******************
    // LEER OBJETOS JSON
    // *******************
    public static JSONObject getObjectFromString(String jsonObjectStr) {
        JSONObject json;
        json = new JSONObject(jsonObjectStr);
        return json;
    }

    public static JSONArray getArrayFromString(String jsonStr) {
        JSONArray json;
        json = new JSONArray(jsonStr);
        return json;
    }

    public static JSONObject getObjectFromFile(String strFile) {
        JSONObject json;
        json = new JSONObject(getStringFromFile(strFile));
        return json;
    }

    public static JSONArray getArrayFromFile(String strFile) {
        JSONArray json;
        json = new JSONArray(getStringFromFile(strFile));
        return json;
    }

    public static JSONObject getObjectFromUrl(String strConnection) {
        JSONObject json;
        json = new JSONObject(getStringFromUrl(strConnection));
        return json;
    }

    public static JSONArray getArrayFromUrl(String strConnection) {
        JSONArray json;
        json = new JSONArray(getStringFromUrl(strConnection));
        return json;
    }

    // **********************
    // getStringFromUrl
    // **********************
    public static String getStringFromUrl(String strConnection) {
        String jsonText = "";

        // Conexión sin proxy
        try {
            URI uri = new URI(strConnection);
            URL url = uri.toURL();
            URLConnection uc = url.openConnection();
            HttpURLConnection conn = (HttpURLConnection) uc;

            // La conexión se va a realizar para poder enviar y recibir 
            // información en formato JSON 
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-type", "application/json");

            // Se va a realizar una petición con el método GET
            conn.setRequestMethod("GET");

            // Ejecutar la conexión y obtener la respuesta
            try (
                    InputStreamReader rd = new InputStreamReader(conn.getInputStream(), Charset.forName("UTF-8"));  
                    BufferedReader bf = new BufferedReader(rd);) {

                
                String str;
                while ((str = bf.readLine()) != null) {
                    jsonText += str.trim();
                }
                
            }
        } catch (MalformedURLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } catch (URISyntaxException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }

        return jsonText;
    }

    // **********************
    // getStringFromFile
    // **********************
    private static String getStringFromFile(String strFile) {
        String jsonText = "";
        
        try {
            jsonText = new String(Files.readAllBytes(Paths.get(strFile)), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return jsonText;
            

        /*
        File archivo = new File(strFile);  // Declarar fichero
        try ( FileReader fr = new FileReader(archivo);  BufferedReader br = new BufferedReader(fr);) {
            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                jsonText += linea;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return jsonText;
        */
    }

}
