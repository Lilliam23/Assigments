package application;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Set;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


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
   Scene scene = new Scene(new Group());TextField tb = new TextField();
  
   

   // Prepare scene
   

   scene.setFill(Color.web("#8B008B"));
   scene.getWindow();
   
   

   // Label

           Label lbl = new Label();
           lbl.setLayoutX(300);
           lbl.setLayoutY(100);
           lbl.setFont(Font.font("Times New Roman", FontWeight.NORMAL, FontPosture.ITALIC, 24));
  
 
      		
    // Button 				
  
   Button btnStart = new Button("Start");
           btnStart.setLayoutX(600);
           btnStart.setOnAction((ActionEvent e) -> {
               try {
            	   TextAn();
               } catch (Exception e1) {
                   e1.printStackTrace();
               }
              
           });
           

  
   VBox RBpane = new VBox();
   RBpane.setPadding(new Insets(10,10,10,10));
   RBpane.setSpacing(5);
   RBpane.getChildren().addAll(btnStart);
  

   // Prepare the Vertical Box

   VBox vbox = new VBox();
   vbox.setMaxWidth(700);
   vbox.setSpacing(5);
   vbox.setPadding(new Insets(10, 10,10, 10));
  
           vbox.getChildren().addAll(lbl, RBpane);
     
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
	    	//sorting list
	        Set<Map.Entry<String, Integer>> set = map.entrySet(); 
	        List<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String, Integer>>(set);  
	        Collections.sort( sortedList, new Comparator<Map.Entry<String, Integer>>() 
	     

	        {
	     public int compare ( Map.Entry<String, Integer> a, Map.Entry<String, Integer> b )
	       {
	                return (b.getValue()).compareTo( a.getValue() ); 
	            }
	        } );
	        
	        
	        // printing the list
	        for(Map.Entry<String, Integer> i:sortedList){
	            System.out.println(i.getKey()+" -> "+i.getValue());
	        }
	        
	        in.close();
	    }

		}
}
