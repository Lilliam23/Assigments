
public class BusinessLoan extends Loan {
	
	
	public double primeRate = .01;
	
	// Constructor

	public BusinessLoan(int loanNumber, String lastName, double loanAmount, int term, double interstRate) {
		super(loanNumber, lastName, loanAmount, term);
		
	}

	// Get Prime Rate
	public double getPrimeRate() {
		
		brate = primeRate + interestRate;
		
		return brate;
	}

	// Set Prime Rate 
	public void setPrimeRate(double primeRate) {
		this.primeRate = brate;
	}


	// Total Amount of loan
	public double totalLoanAmount(double loanAmount, double interestRate, int term) {
		double totalLoanAmount = (loanAmount * brate) * term;
		return totalLoanAmount;
	}
}

