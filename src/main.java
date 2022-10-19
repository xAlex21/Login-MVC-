import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets; 
import javafx.geometry.Pos; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.GridPane; 
import javafx.scene.text.Text; 
import javafx.scene.control.TextField; 
import javafx.stage.Stage; 

public class main extends Application { 
   @Override 
   public void start(Stage stage) throws IOException { 
	   
	  loginController controller = new loginController();
	  
      //creating label email 
      Text text1 = new Text("Usuario:");       
      
      //creating label password 
      Text text2 = new Text("Contraseña:"); 
	  
      //Creating Text Filed for email        
      TextField textField1 = new TextField();       
      
      //Creating Text Filed for password        
      TextField textField2 = new TextField();  
       
      //Creating Buttons 
      Button button1 = new Button("Acceder"); 
      Button button2 = new Button("Cancelar");  
      
      
      EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() { 
          public void handle(ActionEvent e) 
          {
        	  String nombreUsuario = textField1.getText();
        	  String contrasenaUsuario = textField2.getText();
        	  if(nombreUsuario != null && !nombreUsuario.isEmpty()) {
        		  controller.comprobarDatos(nombreUsuario, contrasenaUsuario);
        	  }
              
          } 
      }; 
      button1.setOnAction(event); 
      
      //Creating a Grid Pane 
      GridPane gridPane = new GridPane();    
      
      //Setting size for the pane  
      gridPane.setMinSize(400, 200); 
       
      //Setting the padding  
      gridPane.setPadding(new Insets(10, 10, 10, 10)); 
      
      //Setting the vertical and horizontal gaps between the columns 
      gridPane.setVgap(5); 
      gridPane.setHgap(5);       
      
      //Setting the Grid alignment 
      gridPane.setAlignment(Pos.CENTER); 
       
      //Arranging all the nodes in the grid 
      gridPane.add(text1, 0, 0); 
      gridPane.add(textField1, 1, 0); 
      gridPane.add(text2, 0, 1);       
      gridPane.add(textField2, 1, 1); 
      gridPane.add(button1, 0, 2); 
      gridPane.add(button2, 1, 2);  
      
      //Creating a scene object 
      Scene scene = new Scene(gridPane);  
      
      //Setting title to the Stage 
      stage.setTitle("Grid Pane Example"); 
         
      //Adding scene to the stage 
      stage.setScene(scene); 
         
      //Displaying the contents of the stage 
      stage.show(); 
   } 
   public static void main(String args[]){ 
      launch(args); 
   } 
} 