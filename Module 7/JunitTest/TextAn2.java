package JunitTest;

import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import java.io.*;

/**
 * 
 * @author lilliamcastro
 *
 */

public class TextAn2 {
	/**
	 * 
	 * @param string 
	 * @param args
	 * @throws Exception
	 */
	
@Test
    public void  main() throws Exception {
    	
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



