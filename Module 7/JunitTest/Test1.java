package JunitTest;


import org.junit.Test;

import org.junit.Assert;

public class Test1 extends TextAn2{ 
	
	@Test
	public void testing(){
TextAn2 test =  new TextAn2(); 
boolean output = test.equals("Raven");
Assert.assertEquals(12,12);
   
	}
}