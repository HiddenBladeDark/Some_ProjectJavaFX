/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import ConexionDB.ConexionDb;
import Persona.Persona;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {
    
    
    
    
    
    
    
    //Declaracion de botones
    @ FXML private Button boting ;
    @ FXML private Button botedit;
    @ FXML private Button botelim;
    private Button botnue;
           
    //Declaracion de TextField
    @ FXML private TextField txtidusur;
    @ FXML private TextField txttipo;
    @ FXML private TextField txtnom;
    @ FXML private TextField txtape;
    @ FXML private TextField txtusu;
    @ FXML private TextField txtcon;
    @ FXML private TextField txtest;
    @ FXML private TextField txtgen;
    
    //Declaracion de tabla y las columnas
    
    @ FXML private TableView<Persona>tablausuario; //Aqui estaran la clase Persona
    @ FXML private TableColumn<Persona,String> cold;
    @ FXML private TableColumn<Persona,String> coltip;
    @ FXML private TableColumn<Persona,String> colnom;
    @ FXML private TableColumn<Persona,String> colape;
    @ FXML private TableColumn<Persona,String> colusu;
    @ FXML private TableColumn<Persona,String> colcontra;
    @ FXML private TableColumn<Persona,String> colest;
    @ FXML private TableColumn<Persona,String> colgen;
            ObservableList<Persona>Tabla = FXCollections.observableArrayList();
        
        private int PosicionPersonaEnTabla;    
    @FXML
    private Button txtnue;
        
        
        
        //Metodos de los botones
    private void boting(ActionEvent event){
       txtidusur.setText("");
       txttipo.setText("");
       txtnom.setText("");
       txtape.setText("");
       txtusu.setText("");
       txtcon.setText("");
       txtest.setText("");
       txtgen.setText("");
       botedit.setDisable(true);
       botelim.setDisable(true);
       botnue.setDisable(true);
       
       
       
        
        
    }
    private void botnue(ActionEvent event) {
    /*
        Persona Person = new Persona();
    Person.idUsuario.set(Integer.parseInt(txtidusur.getText()));
    Person.idTipoUsua.set(Integer.parseInt(txttipo.getText()));
    Person.NombUsua.set(txtnom.getText());
    Person.ApelUsua.set(txtape.getText());
    Person.EstaUsua.set(txtest.getText());
    Person.GeneUsua.set(txtgen.getText());
    Person.PassUsua.set(txtcon.getText());
    Person.NickUsua.set(txtusu.getText());
    Tabla.add(Person);
    
    }
    private void botedit(ActionEvent event) {
  Persona Person = new Persona();
    Person.idUsuario.set(Integer.parseInt(txtidusur.getText()));
    Person.idTipoUsua.set(Integer.parseInt(txttipo.getText()));
    Person.NombUsua.set(txtnom.getText());
    Person.ApelUsua.set(txtape.getText());
    Person.EstaUsua.set(txtest.getText());
    Person.GeneUsua.set(txtgen.getText());
    Person.PassUsua.set(txtcon.getText());
    Person.NickUsua.set(txtusu.getText());
    Tabla.set(PosicionPersonaEnTabla, Person);
    }
    private void botelim(ActionEvent event) {
    *    Tabla.remove(PosicionPersonaEnTabla);
    }
*/
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        try {
            Connection Conectar = ConexionDb.getConnection();
            
            
            
            ResultSet Ver = Conectar.createStatement().executeQuery("Select * from Persona");
            
            while (Ver.next()) {
              Tabla.add(new Persona(Ver.getDouble("idUsuario"), Ver.getDouble("IdTipoUsua"), Ver.getString("NomUsua"),
                      Ver.getString("ApelUsua"),
                      Ver.getString("GeneUsua"), 
                      Ver.getString("EstaUsua"),
                      Ver.getString("NickUsua"),
                      Ver.getString("PassUsua")));
                
            }
            
            
            cold.setCellValueFactory(new PropertyValueFactory<>("idUsuario"));
            coltip.setCellValueFactory(new PropertyValueFactory<>("idTipoUsua"));
            colnom.setCellValueFactory(new PropertyValueFactory<>("NombUsua"));
            colape.setCellValueFactory(new PropertyValueFactory<>("ApelUsua"));
            colusu.setCellValueFactory(new PropertyValueFactory<>("GeneUsua"));
            colcontra.setCellValueFactory(new PropertyValueFactory<>("EstaUsua"));
            colest.setCellValueFactory(new PropertyValueFactory<>("NickUsua"));
            colgen.setCellValueFactory(new PropertyValueFactory<>("PassUsua"));
            
            
            tablausuario.setItems(Tabla);
            
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    

    }
    
    

