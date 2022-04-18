package application;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import java.util.Set;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sun.tools.jconsole.OutputViewer;


/**
 * 
 * @author lilliamcastro
 *
 */


public class word_occurence extends Application
{

  
	/**
	 * 
	 * @override 
	 * @param Stage
	 * @param stage
	 * 
	 */
	


   @Override
   public void start(Stage stage)
   {
   Scene scene = new Scene(new Group());
   TextField tb = new TextField();

   

   // Prepare scene
   

   scene.setFill(Color.web("#8B008B"));
   scene.getWindow();
   
   

   // Label

           Label lbl = new Label();
           lbl.setLayoutX(300);
           lbl.setLayoutY(300);

  
 
      		
    // Button 				
  
   Button btnStart = new Button("Start Text Analyzer");
           btnStart.setLayoutX(600);
           btnStart.setOnAction((ActionEvent e) -> {
               try {
            	  TextAn();
            	  tb.setText(null);
               } catch (Exception e1) {
                   e1.printStackTrace();
               }
              
           });
           
           //textfiled
   
           TextArea area = new TextArea();
  
           area.setPrefHeight(300);
           area.setPrefWidth(500);
    
           
           //Creating a hbox to hold the pagination
           HBox hbox = new HBox();
           hbox.setSpacing(20);
           hbox.setPadding(new Insets(20, 50, 50, 60));
           hbox.getChildren().addAll( area);

   
   VBox RBpane = new VBox();
   RBpane.setPadding(new Insets(10,10,10,10));
   RBpane.setSpacing(5);
   RBpane.getChildren().addAll(btnStart);
  

   // Prepare the Vertical Box

   VBox vbox = new VBox();
   vbox.setMaxWidth(700);
   vbox.setSpacing(5);
   vbox.setPadding(new Insets(10, 10,10, 10));
  
           vbox.getChildren().addAll(lbl, RBpane,area,hbox);
     
   ((Group) scene.getRoot()).getChildren().addAll(vbox);

   
   
   // Prepare the Stage


   stage.setScene(scene);
   stage.setTitle("Word Occurrences");
   stage.setWidth(700);
   stage.setHeight(550);
   stage.setScene(scene);

   stage.show();
   
  
   }
  
   
	/**
	 *
	 * @throws Exception
	 */
	

   private void TextAn() throws Exception {
	// TODO Auto-generated method stub
	


{
	
	    	
	    	String Word;
	    	
	    	//url reading file 
	   

	        URL poem = new URL("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");
	        BufferedReader in;
			in = new BufferedReader(
			new InputStreamReader(poem.openStream()));
		  
			 // Mapping
			  
	       
	        Map<String,Integer> map = new HashMap<String, Integer>(); 
	        
	    	while ((Word = in.readLine()) != null)
	        {
	    		
	    		String[] word = Word.split("[ \n\t\r.,;:!?(){}]");           
	       for ( String val : word)
	    		   
	            if(map.containsKey(val) == false)
	                map.put(val,1);
	            else
	            {
	                int count = (int)(map.get(val)); 
	                map.remove(val);  
	                map.put(val,count+1); 
	            }
	        }
	    	//Creating a map to store the word and corresponding frequency.
			Map<String,Integer> frequency = new LinkedHashMap<>();
	//Same as word storing section accessing the database and get the resultset.
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost/wordOccurences","root","8528");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("Select * from word");
					while(rs.next()){
						String s = rs.getString(1);
						if(frequency.get(s)==null){
							frequency.put(s,1);
						}
						else{
							frequency.put(s,frequency.get(s)+1);
						}
					}
	//Closing the database connection.
					con.close();
				}
				catch(ClassNotFoundException | SQLException s){
					System.out.println(s.getMessage());
				}
	//Printing the words with it's frequency.
				Set<String> key = frequency.keySet();
				for(String k:key){
					System.out.println("Word: "+k+" frequency: "+frequency.get(k));
				}
		
	        
	        in.close();
	    }

		}
}
