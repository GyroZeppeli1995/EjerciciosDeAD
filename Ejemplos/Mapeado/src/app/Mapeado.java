/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import clases.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Salvador Pareja Asín
 */
public class Mapeado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        Users userData = new Users(1, "Juan");

        System.out.println(userData.toString());

        String datos = "2,Pedro";
        String[] campos = datos.split(",");
        Users userData2 = new Users();
        userData2.setUserId(Integer.valueOf(campos[0]));
        userData2.setUserName(campos[1]);

        System.out.println(userData2.toString());

        //Mapeo automatico
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Users userData3 = new Users(3, "Ana");
        String userDataString = gson.toJson(userData3);
        System.out.println(userDataString);

        // Deserializar objeto desde un String (String a Objeto)
        String userJson = "{'userId':4, 'userName':'Sergio'}";
        Users userObject = gson.fromJson(userJson, Users.class);
        System.out.println(userObject.toString());

        // Serializar una lista de objetos utilizando la combinación de:
// gson.toJson que usa a su vez User.toString()
        ArrayList<Users> lista = new ArrayList<>();
        lista.add(new Users(5, "Jose"));
        lista.add(new Users(6, "María"));

        String userListaString = gson.toJson(lista);
        System.out.println(userListaString);

        
        String jsonString = """
                            [
                                {
                                    "usersId": 5,
                                    "userName": "Elena"
                                },
                                {
                                    "usersId": 5,
                                    "userName": "Elena"
                                }
                            ]
                            """;
        // *******************************
// Convertir (De JSONString a RAM)
// *******************************
        ArrayList<Users> listaUsuarios
                = gson.fromJson(
                        jsonString,
                        new TypeToken<ArrayList<Users>>() {
                        }.getType()
                );
        System.out.println(listaUsuarios.toString());
    }
    

}
