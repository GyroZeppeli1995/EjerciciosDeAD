/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author alumno
 */
public class Utilidad {
    
    public static void mostrarArrayFiltrado(JSONArray jsonArray, String filtroClave, String filtroValor)
    {
        JSONObject objetoGenerico;

        for (Object elemento : jsonArray) {
            
            
            objetoGenerico = (JSONObject) elemento;
            
            
            
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
