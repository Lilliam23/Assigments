import java.util.Random;

import org.junit.Test;


class Summation extends Thread {

private int[] arr;
private int low, high, partial;



	public Summation(int[] arr, int low, int high)

	{
	this.arr = arr;
	this.low = low;
	this.high = Math.min(high, arr.length);
	}

	// partial sum
	
	public int getPartialSum()
	{
	return partial;
	}


	public void run()

	{
	partial = sum(arr, low, high);
	}


	public static int sum(int[] arr)

	{
	return sum(arr, 0, arr.length);
	}


	public static int sum(int[] arr, int low, int high)

	{
	int total = 0;
	for (int i = low; i < high; i++) {
		total += arr[i];
	}
	return total;
	}

	//parallel Sum
	
	public static int parallelSum(int[] arr)

	{
	return parallelSum(arr, Runtime.getRuntime().availableProcessors());
	}


	public static int parallelSum(int[] arr, int threads)

	{

	int size = (int) Math.ceil(arr.length * 1.0 / threads);

	Summation[] sums = new Summation[threads];

	for (int i = 0; i < threads; i++) {
		sums[i] = new Summation(arr, i * size, (i + 1) * size);
		sums[i].start();
	}

	try {

		for (Summation sum : sums) {
			sum.join();

		}

	} catch (InterruptedException e) { }

	int total = 0;
	
	for (Summation sum : sums) {
		total += sum.getPartialSum();
	}
	return total;
	}

}



public class Module8 {
	
	// main method
	@Test
	public void main()

	{

	Random rand = new Random();
	int[] arr = new int[200000000];
	
	for (int i = 0; i < arr.length; i++) {

		arr[i] = rand.nextInt(10) + 1;
	}
	
	long start = System.currentTimeMillis();
	
	System.out.println(Summation.sum(arr));
	System.out.println("Single: " + (System.currentTimeMillis() - start));
	start = System.currentTimeMillis();
	System.out.println(Summation.parallelSum(arr));
	System.out.println("Parallel: " + (System.currentTimeMillis() - start));

	}

}