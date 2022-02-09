import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TextAnalyzer
{
    public static void main(String[] args) throws FileNotFoundException {
//file to be read
    	File file = new File("/Users/lilliamcastro/OneDrive - Valencia College/Valencia College/CEN 3024C Software Development/Module 2/The Raven.rtf");
        Scanner scan = new Scanner(file);
        
        Map<String,Integer> map = new HashMap<String, Integer>(); 
        while (scan.hasNext())
        {
            String val = scan.next(); 
            if(map.containsKey(val) == false) 
                map.put(val,1);
            else 
            {
                int count = (int)(map.get(val)); 
                map.remove(val);  
                map.put(val,count+1); 
            }
        }
        Set<Map.Entry<String, Integer>> set = map.entrySet(); 
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<Map.Entry<String, Integer>>(set);  
        Collections.sort( sortedList, new Comparator<Map.Entry<String, Integer>>() 
        {
            public int compare( Map.Entry<String, Integer> a, Map.Entry<String, Integer> b ) 
            {
                return (b.getValue()).compareTo( a.getValue() ); 
            }
        } );
        // printing the list
        for(Map.Entry<String, Integer> i:sortedList){
            System.out.println(i.getKey()+" = "+i.getValue());
        }
    }
}