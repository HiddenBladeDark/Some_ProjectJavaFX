package Persona;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;


/**
 *
 * @author HiddenBladeDark
 */
public class Persona {
    
    // Declaracion variables Personas
       /* public SimpleDoubleProperty idUsuario = new SimpleDoubleProperty();
        public SimpleDoubleProperty idTipoUsua = new SimpleDoubleProperty();
        public SimpleStringProperty NombUsua = new SimpleStringProperty();
        public SimpleStringProperty ApelUsua = new SimpleStringProperty();
        public SimpleStringProperty GeneUsua = new SimpleStringProperty();
        public SimpleStringProperty EstaUsua = new SimpleStringProperty();
        public SimpleStringProperty NickUsua = new SimpleStringProperty();
        public SimpleStringProperty PassUsua = new SimpleStringProperty();
        */      
    Double idUsuario, IdTipoUsua;
    String NomUsua, ApelUsua, GeneUsua, EstaUsua, NickUsua, PassUsua;
    
    
        
    // Get y Set
        /*
        public Double getidTipoUsua(){
        return idTipoUsua.get();
        }
        public String getNombUsua(){
        return NombUsua.get();
        }
        public String getApelUsua(){
        return ApelUsua.get();
        }
        public String getGeneUsua(){
        return GeneUsua.get();
        }
        public String getEstaUsua(){
        return EstaUsua.get();
        }
        public String getPassUsua(){
        return PassUsua.get();
        }
        public String getNickUsua(){
        return NickUsua.get();
        }
        */

    public Persona(Double idUsuario, Double IdTipoUsua, String NomUsua, String ApelUsua, String GeneUsua, String EstaUsua, String NickUsua, String PassUsua) {
        this.idUsuario = idUsuario;
        this.IdTipoUsua = IdTipoUsua;
        this.NomUsua = NomUsua;
        this.ApelUsua = ApelUsua;
        this.GeneUsua = GeneUsua;
        this.EstaUsua = EstaUsua;
        this.NickUsua = NickUsua;
        this.PassUsua = PassUsua;
    }
        
        
}
