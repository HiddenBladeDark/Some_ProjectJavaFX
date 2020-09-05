/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;



import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import util.ConexionDB;



/**
 *
 * @author SOFTAKE
 */
public class FXMLDocumentController implements Initializable {
    
    
    
    //Campos formulario textfield and passwordfield
    @FXML
    private ComboBox<String>tipousua;
    @FXML
    private ComboBox<String>genero;
    @FXML
    private TextField txtusur;
    @FXML
    private TextField txtced;
    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtape;
    @FXML
    private PasswordField txtcont; 
  
    //Campos formulario botones
    @FXML
    private Button btnsave; 
 
    //Campos formulario label
    @FXML
    private Label status;
    
    //Campos Formulario TableView
    @FXML
    private TableView tabla;
    
    //Inicializamos el controlador de la conexion DB y Anti-Injection
    
    PreparedStatement preparedStatement;
    Connection connection;  
    public FXMLDocumentController()
    {
        //Instanciamos ConexionDB
        connection=(Connection) ConexionDB.Conexion();
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 

    {
        //Inicializamos los campos de ComboBox de las opciones
            
            //Genero ComboBox
        genero.getItems().addAll("Masculino","Femenino","Otro");
        genero.getSelectionModel().select("Masculino");
        ObservarListaColumna();
        fetRowList();
        
            //Tipo de usuario ComboBox
        tipousua.getItems().addAll("1","2","3");
        tipousua.getSelectionModel().select("3");
        ObservarListaColumna();
        fetRowList();

    }

  
    //Limpiamos los campos del formulario
    private void LimpiarCamposFORM()
    {
    txtusur.clear();
    txtced.clear();
    txtnom.clear();
    txtape.clear();
    txtcont.clear();
    }
    
    
    
    private String GuardarDatos()
    {
    try{
    //Hacemos la insercion a la base de datos a traves del procedimiento almana
    String Almacen = "call CrudUsuario(?,?,?,?,?,?,?,'guardar')";
    //Al llamar el metodo PreparedStatement se asegura que no se haran injecciones
    //Que no sean del formulario
    //Tiene que ir en orden como se ve en el formulario o si no tira error
    preparedStatement =(PreparedStatement) connection.prepareStatement(Almacen);
    preparedStatement.setString(1,txtced.getText());
    preparedStatement.setString(2,tipousua.getValue());
    preparedStatement.setString(3,txtnom.getText());
    preparedStatement.setString(4,txtape.getText());
    preparedStatement.setString(5,genero.getValue());
    preparedStatement.setString(6,txtusur.getText());
    preparedStatement.setString(7,txtcont.getText());
      
    
    preparedStatement.executeUpdate();
    status.setTextFill(Color.GREEN);
    status.setText("Se agrego el usuario correctamente");
    //Cuando se guarde correctamente traemos la fila
    fetRowList();
    //Luego limpiamos los datos
    LimpiarCamposFORM();
    return "Limpiamos Campos";
    

    }catch(SQLException ex)
    {  
        
        //Si no se guarda y hay un error que imprima el mensaje de error
        System.out.println(ex.getMessage());
        status.setTextFill(Color.TOMATO);
        status.setText(ex.getMessage());
        return "Error al guardar los datos, reinice la aplicación";
    } 
    }
  
    //Metodo para eliminar datos
    private String Eliminar()
        {
            //Ingresamos setencia en una variable
        String sql = "delete from usuario where idUsuario= ?";
        
        //Try por si hay un error en la ejecucion de eliminar
        try{
            //Preparamos la setencia de sql ya almacenada en statement
        java.sql.PreparedStatement pst = connection.prepareStatement(sql);
             pst.setString(1, txtced.getText());
             pst.executeUpdate();
             
            
             
                 
                 
          status.setTextFill(Color.GREEN);       
          status.setText("Se elimino el usuario correctamente");
           fetRowList(); 
           LimpiarCamposFORM();
             
             return"Se limpio campos";
             
         } catch (SQLException ex )
         {
             System.out.println(ex.getMessage());
        status.setTextFill(Color.TOMATO);
        status.setText(ex.getMessage());
        return "Error al guardar los datos, reinice la aplicación";
         } 
         
        }
    
    private String actualizar()
    {
       //Ingresamos setencia en una variable
     String Act = "call CrudUsuario(?,?,?,?,?,?,?,'modificar')";
        // String sql = "UPDATE usuario SET idUsuario=?,idTipoUsua=?,NombUsua=?,ApelUsua=?,GeneUsua=?,NickUsua=?,PassUsua=? WHERE idUsuario=?";  
        try{
       
            
            preparedStatement =(PreparedStatement) connection.prepareStatement(Act);
    preparedStatement.setString(1,txtced.getText());
    preparedStatement.setString(2,tipousua.getValue());
    preparedStatement.setString(3,txtnom.getText());
    preparedStatement.setString(4,txtape.getText());
    preparedStatement.setString(5,genero.getValue());
    preparedStatement.setString(6,txtusur.getText());
    preparedStatement.setString(7,txtcont.getText());
   
            
            
            /*
          java.sql.PreparedStatement pst = connection.prepareStatement(sql);
             pst.setString(1, txtced.getText());
             pst.setString(2, tipousua.getValue());
             pst.setString(3, txtnom.getText());
             pst.setString(4, txtape.getText());
             pst.setString(5, genero.getValue());
             pst.setString(6, txtusur.getText());
             pst.setString(7,txtcont.getText());
             pst.setString(8, txtestad.getText());
             pst.executeUpdate();  */
            preparedStatement.executeUpdate();
    status.setTextFill(Color.GREEN);       
          status.setText("Se actualizo el usuario correctamente");
           fetRowList(); 
           LimpiarCamposFORM();
             
             return"Se limpio campos";
             
    }catch (SQLException ex )
    {  
    System.out.println(ex.getMessage());
        status.setTextFill(Color.TOMATO);
        status.setText(ex.getMessage());
        return "Error al guardar los datos, reinice la aplicación";
    }
    }
    
    
    
    
    
    //Observar los datos de la tabla
    private ObservableList<ObservableList> Observar;
    String SQL ="SELECT * from usuario";
    
    
    
    
    //Listamos los datos de las columnas
private void ObservarListaColumna()
    {
        
   try{     
   ResultSet ResultadoEnvio = connection.createStatement().executeQuery(SQL);
    
    //Para traer los datos de la tabla en un ciclo SQL
    for (int i=0; i < ResultadoEnvio.getMetaData().getColumnCount();i++){
    //No se usa estilos en la tabla para llegar mas rapido
    final int j = i;
    //Constructor de la tabla
    TableColumn col = new TableColumn(ResultadoEnvio.getMetaData().getColumnName(i+1).
            toUpperCase());
    col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, 
            ObservableValue<String>>()
            {
            public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param){
                return new SimpleStringProperty(param.getValue().get(j).toString());
            }
            });
    //Metodo para agregar y quitar columnas
    
    tabla.getColumns().removeAll(col);
    tabla.getColumns().addAll(col);
    
        System.out.println("Columna ["+ i + "] ");
   }    
   }catch (Exception e)
   {
       System.out.println("Error"+ e.getMessage());
   }
    }
    


    //Metodo para traer los resultados de las filas de la consulta
    private void fetRowList() {
    //Arreglo con los datos de las filas y columnas    
        Observar = FXCollections.observableArrayList();
        ResultSet resultado;
        try{
        //Ejecutamos la consulta y traemos los resultados:
        resultado = connection.createStatement().executeQuery(SQL);
        //Se imprime mientras exista filas
        while (resultado.next()){
            //iterate row
            ObservableList row = FXCollections.observableArrayList();
            for (int i = 1; i <= resultado.getMetaData().getColumnCount(); i++) {
                //iterador de filas
                row.add(resultado.getString(i));
            }
            //Mensaje de control filas agregadas:
            System.out.println("Fila [1] Agregada"+ row);
            Observar.add(row);
     
        }
        tabla.setItems(Observar);
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        
        
        
    }
   
    
    
    
        //Funcionalidad del boton para guardar
        @FXML
        private void enviar(ActionEvent event)
        {
        if(txtusur.getText().isEmpty()
        || txtusur.getText().isEmpty()
        || txtced.getText().isEmpty()
        || txtnom.getText().isEmpty()
        || txtape.getText().isEmpty()
        || txtcont.getText().isEmpty()

         ) {
      //Cambiar mensaje del label
         status.setTextFill(Color.RED);
        status.setText("Debes ingresar todos los campos obligatoriamente");
     }else
        {   
        GuardarDatos();
        }
        }    
        
    //Funcionalidad del boton Consultar
      @FXML
      private void Eliminar(ActionEvent event)
      {
         if(txtced.getText().isEmpty()
       

         ) {
      //Cambiar mensaje del label 
        status.setTextFill(Color.TOMATO);
        status.setText("Debes ingresar la cedula para eliminar");
        
     }else
        {   
        Eliminar();
        }
 }   
      //Cerrar aplicacion mediante evento boton
   @FXML   
   private void cerrar()
   {
   System.exit(0); 
   }
   @FXML
    private void actua()
    {
    actualizar();
    }
     

    private void setText(String debes_Ingresar_los_campos_Obligatorios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

