
public abstract class Loan implements LoanConstants{
	
	 int loanNumber;
	 String lastName;
	 double loanAmount;
	 double interestRate;
	 int term;
	 double brate;
	 double prate;
	 
	//constructor 
	
		public Loan(int loanNumber, String lastName, double loanAmount, int term) {
			super();
			this.loanNumber = loanNumber;
			this.lastName = lastName;
			this.loanAmount = loanAmount;
			this.term = term;
		}

		// Setters
		public void setLoanNumber(int loanNumber) {
			this.loanNumber = loanNumber;
		}
		
		public void setLoanAmount(double loanAmount) {
			this.loanAmount = loanAmount;
			
			if (loanAmount > maxAmount)
				
				this.loanAmount = loanAmount;

			else {
				System.out.println("Amount not Allow");
			}

		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public void setInterestRate(double interestRate) {
			this.interestRate = interestRate;
		}
		
		public void setTerm(int term) {
			this.term = term;
		
		}

		// Getters
		
		public int getLoanNumber() {
			return loanNumber;
		}
		
		public String getLastName() {
			return lastName;
		}

		public double getLoanAmount() {
			return loanAmount;
		}
	
		public double getInterestRate() {
		
			 if (interestRate == 1)
				 
				 interestRate = brate;
			 else
				 interestRate = prate;
			
			 return interestRate;
		}

		public int getTerm() {
			
			if ( term != longTerm &&  term != mediumTerm && term != shortTerm )
				
				return shortTerm;

			else {
				
			return term;}
		}

		
		public String toString() {
			return "Last Name: "+ lastName +"\n"+
					"Loan Number: " + loanNumber +"\n"+
					"Loan Amount: " + loanAmount +"\n"+
					"Loan Interest Rate "+ interestRate +"\n"+
					"Loan Term " + term;
		
		}
	
	}