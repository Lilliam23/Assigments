/**
 * Fibonacci program - Both iterative and recursive versions
 * 
 * @author Lilliam Castro
 *
 */
public class Fibonacci {
	
	/**
	 * Iterative implementation for Nth fibonacci number
	 * @param n
	 * @return n
	 */
	public static int fibonacciIterative(int n) {
		if(n <= 1) {
			return n;
		}
		int fib = 1;
		int prevFib = 1;
		
		for(int i=2; i<n; i++) {
			int temp = fib;
			fib+= prevFib;
			prevFib = temp;
		}
		return fib;
	}
	
	/**
	 * Recursive implementation for Nth fibonacci number
	 * 
	 * @param n
	 * @return n
	 */
	
	public static int fibonacciRecursive(int n) {
		if(n <= 1) {
			return n;
		}
		return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
	}


	/**
	 * This is the Main Method.
	 *
	 * @param args
	 */
	
	public static void main(String args[]) {
		
		long start_time ,end_time;
		int difference,difference2;
		int i,n=20;
		
		System.out.print("n\tIterative\tRecursive\n");
		System.out.print("__\t____________\t___________\n");
		
		//Loop
		for(i=5;i<=n;i++) 
			
		{
			
		start_time = System.nanoTime();
		fibonacciIterative(i);
		end_time = System.nanoTime(); 
		difference = (int)((end_time - start_time) );
		
		start_time = System.nanoTime();
		fibonacciRecursive(i); 
		end_time = System.nanoTime(); 
		difference2 = (int)((end_time - start_time)); 
		
		// result calculation
		System.out.print(i+"\t\t"+difference+"\t\t"+difference2 +"\t\n");

		
		
		
}
}
}