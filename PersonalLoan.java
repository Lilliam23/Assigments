
public class PersonalLoan extends Loan {
	

	public double primeRate = .01;
	
	//Constructor
	public PersonalLoan(int loanNumber, String lastName, double loanAmount, int term, double interestRate) {
		super(loanNumber, lastName, loanAmount, term);
	
	}

	
	
	// Set Prime Rate 
	public double setPrimeRate(double loanAmount, double primeInterestRate) {
		primeInterestRate = loanAmount * primeInterestRate;
		return primeInterestRate;
	}
	// Get Prime Rate
	public double getPrimeRate(double loanAmount, double primeInterestRate) {
		
		prate = primeRate + interestRate;
		
		return prate;
	}
	
	
	// Total Amount of loan
	
	public double totalLoanAmount(double loanAmount, double interestRate) {
		double totalLoanAmount = loanAmount * prate;
		return totalLoanAmount;
	}
}
