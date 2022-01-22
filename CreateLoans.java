import java.util.Scanner;

public class CreateLoans {
	
	public static void main(String[] args) {
		// Loan array
		/*information used to code https://www.w3schools.com/java/java_arrays.asp */
		Loan Loan[] = new Loan[5];
	
		// scanner object
		//*https://www.javatpoint.com/how-to-get-input-from-user-in-java */
		Scanner scan = new Scanner(System.in);
		for(int i=0; i<Loan.length; i++) {
			
		// ask for prime Interest Rate
		System.out.print("Enter Pirme Rate: ");
		//get interest rate
		double interestRate= scan.nextDouble();
		//ask name
		System.out.print("Enter Last Name: ");
		// get Name
		String lastName = scan.next();
		//ask Type of Loan Business or Personal
		System.out.print("Enter Type of Loan Business or Personal: ");
		//get type of Loan
		String type = scan.next();
		//term
		System.out.print("Enter Number of Years: ");
		//get term
		int term = scan.nextInt();
		//loan amount
		System.out.print("Enter Loan amount: ");
		//get loan amount
		double loanAmount = scan.nextDouble();
		//total payment
		double totalLoanAmount = loanAmount * interestRate * term;
		//print summary
		System.out.println("Loan Details: " );
		System.out.println("Loan- "+(i+1)+"\n" + " Last Name: " +lastName+ "\n"+
				" Loan Type: " + type +"\n" + " Term: " +term +"\n"+
				" Amount of Loan: "+ loanAmount + "\n" +" total amount owed is = " + totalLoanAmount);

	}
		scan.close();
	}
}