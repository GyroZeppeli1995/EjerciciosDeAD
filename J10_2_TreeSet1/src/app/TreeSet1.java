package app;

import java.util.TreeSet;

public class TreeSet1 { 
  public static void main( String[] args ) { 

    TreeSet<String> datos = new TreeSet<String>(); 

    // Añadimos datos 
    datos.add("hola"); 
    datos.add("adios"); 
    datos.add("hasta luego"); 
    datos.add("hola");

    // Y mostramos todos 
    System.out.println("Contenido actual:"); 
    for (String unDato : datos) 
      System.out.println(unDato); 
  } 
}