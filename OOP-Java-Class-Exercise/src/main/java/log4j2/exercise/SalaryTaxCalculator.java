 package log4j2.exercise;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class SalaryTaxCalculator 
{
    private static final Logger logger = LogManager.getLogger(SalaryTaxCalculator.class);

    
    
    public double returnTaxableRate(String salaryString) 
    {
        double taxableAmount = 0.0;
        
        try 
        {
        	
            double salary = Double.parseDouble(salaryString);
            logger.debug("Salary entered: " + salary);

            if (salary < 0) {
                logger.error("Salary is negative: " + salary);
            } else if (salary == 0) {
                logger.warn("Salary is zero: " + salary);
            } else if (salary > 0 && salary <= 500000) {
                logger.info("Salary is within the range 1-500000: " + salary);
                taxableAmount = salary * 0.20;
            } else if (salary >= 1000000) {
                logger.debug("Salary is 1000000 or above: " + salary);
                taxableAmount = salary * 0.20;
            }
        } 
        catch (NumberFormatException e) {logger.fatal("Invalid salary input: " + salaryString, e);}
        
        
        
        return taxableAmount;
    }

    public static void main(String[] args) 
    {
        SalaryTaxCalculator calculator = new SalaryTaxCalculator();
        
        calculator.returnTaxableRate("50000");    // 10000.0
        calculator.returnTaxableRate("-1000");    // 0.0
        calculator.returnTaxableRate("1000000");  // 200000.0
        calculator.returnTaxableRate("abc");      // 0.0
        calculator.returnTaxableRate("0");        // 0.0
    }
}
