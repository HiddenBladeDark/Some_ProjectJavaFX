/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author user
 */
public class Datos {
    
String nom,pass;
    
    
    public boolean ValidarUsuario(String name, String pass){
        if (nom.equals("san") && pass.equals("123")) 
        {
            return true;
        }
        else
        {
            return false;
        }

    }

}