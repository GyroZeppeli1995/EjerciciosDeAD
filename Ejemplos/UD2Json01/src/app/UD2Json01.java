/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author alumno
 */
public class UD2Json01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        JSONObject json = new JSONObject();
        json.put("title", "JSON-Processing With Java EE");
        JSONArray jChapters = new JSONArray();
        jChapters.put("Introduction");
        jChapters.put("1. JSON and Java");
        jChapters.put("2. JSON-Processing API features");
        jChapters.put("3. The Java EE JSON Object model");
        jChapters.put("4. The Java EE JSON Streaming model");
        jChapters.put("Conclusion");
        json.put("chapters", jChapters);
        json.put("released", true);
        json.put("length", 90);
        JSONObject jSourceCode = new JSONObject();
        jSourceCode.put("repositoryName", "JSON-Processing-with-Java-EE");
        jSourceCode.put("url", "github.com/readlearncode");
        json.put("sourceCode", jSourceCode);
        JSONArray jCourses = new JSONArray();
        JSONObject jElement;
        jElement = new JSONObject();
        jElement.put("title", "RESTful Service with JAX-RS 2.0");
        jElement.put("length", 120);
        jCourses.put(jElement);
        jElement = new JSONObject();
        jElement.put("title", "Java Enterprise Edition Introduction");
        jElement.put("length", 130);
        jCourses.put(jElement);
        json.put("complementaryCourse", jCourses);
        json.put("notes", JSONObject.NULL);
        System.out.println(json.toString(2)); // Mostrar Pretty
    }

}
