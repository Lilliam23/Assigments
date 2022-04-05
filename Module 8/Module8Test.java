import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

class Module8Test {

	@Test
	void test() {
		Module8 test1 = new Module8();
		assertFalse(test1.equals(700));
		}
	
	@Test
	void single() throws Exception {
       
        long start = 3000;
		System.out.println("Single: " + (System.currentTimeMillis() - start));
    	start = System.currentTimeMillis();
    	
    	System.out.println("Parallel: " + (System.currentTimeMillis() - start));
		
	}

}
