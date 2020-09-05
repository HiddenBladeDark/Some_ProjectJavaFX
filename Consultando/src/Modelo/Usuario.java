/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author SOFTAKE
 */
public class Usuario {
    
    
  //Declarar atributos requeridos para almacenar la tabla usuario
    
    private String tipousua;
    private String idtipoUsua;
    private String NombUsua;
    private String ApelUsua;
    private String GeneUsua;
    private String EstaUsua;
    private String NickUsua;
    private String PassUsua;
    
    
    //Declaramos las propiedades set and get

    public String getTipousua() {
        return tipousua;
    }

    public void setTipousua(String tipousua) {
        this.tipousua = tipousua;
    }

    public String getidtipoUsua() {
        return idtipoUsua;
    }

    public void setidtipoUsua(String Idtipusua) {
        this.idtipoUsua = Idtipusua;
    }

    public String getNombUsua() {
        return NombUsua;
    }

    public void setNombUsua(String NombUsua) {
        this.NombUsua = NombUsua;
    }

    public String getApelUsua() {
        return ApelUsua;
    }

    public void setApelUsua(String ApelUsua) {
        this.ApelUsua = ApelUsua;
    }

    public String getGeneUsua() {
        return GeneUsua;
    }

    public void setGeneUsua(String GeneUsua) {
        this.GeneUsua = GeneUsua;
    }

    public String getEstaUsua() {
        return EstaUsua;
    }

    public void setEstaUsua(String EstaUsua) {
        this.EstaUsua = EstaUsua;
    }

    public String getNickUsua() {
        return NickUsua;
    }

    public void setNickUsua(String NickUsua) {
        this.NickUsua = NickUsua;
    }

 
    public void setPassUsua(String PassUsua) {
        this.PassUsua = PassUsua;
    }
    
    
    
  
    
    //Retornar los valores obtenidos en los set and get
    public String ToString()
    {
        return "ClassPojo [ Cedula = "+idtipoUsua+",Tipo de Usuario ="+idtipoUsua+",Nombre ="
                +NombUsua+",Apellido="+ApelUsua+",Genero ="+GeneUsua+",EstaUsua ="
                +EstaUsua+",Nick Name ="+NickUsua+", Contraseña="+PassUsua+"]";
    }
    
    
    

    
}
