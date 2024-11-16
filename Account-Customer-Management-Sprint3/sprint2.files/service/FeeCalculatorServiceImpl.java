package service;

public class FeeCalculatorServiceImpl implements FeeCalculationService
{

	@Override
	public double calculateFee(double balance) 
	{
		 if (balance <= 100) {return 20.00;}
		 if (balance > 100 && balance <= 500) {return 15.00;}
		 if (balance > 500 && balance <= 1000) {return 10.00;}
		 if (balance > 1000 && balance <= 2000) {return 5.00;} 
		 if (balance > 2000) {return 0.00;}
		return -balance;
	}

} 