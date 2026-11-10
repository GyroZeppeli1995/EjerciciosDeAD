/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.io.Serializable;

/**
 *
 * @author Salvador Pareja Asín
 */
public class Users implements Serializable{
    //Atributos
    private int userId;
    private String userName;
    
    //Constructores
    public Users() {
    }

    public Users(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
    
    //Getter y Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    //Metodos

    @Override
    public String toString() {
        return "Users{" + "userId=" + userId + ", userName=" + userName + '}';
    }
    
    
    
}
