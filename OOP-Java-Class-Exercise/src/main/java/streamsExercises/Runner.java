package streamsExercises;

import java.math.BigDecimal;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.Logger;

import general.test.Log;
import lambdaExercises.BankAccount;

public class Runner {
	
	static Logger log = Log.getInstance().getLogger();

	public static void main(String[] args) 
	{
		BankAccount account1 = new BankAccount("12345678", "987654", "Mr J Smith", "savings", 1.1, 25362.91);
		BankAccount account2 = new BankAccount("87654321", "234567", "Ms J Jones", "current/checking", 0.2, 550);
		BankAccount account3 = new BankAccount("74639572", "946284", "Dr T Williams", "savings", 1.1, 4763.32);
		BankAccount account4 = new BankAccount("94715453", "987654", "Ms S Taylor", "savings", 1.1, 10598.01);
		BankAccount account5 = new BankAccount("16254385", "234567", "Mr P Brown", "current/checking", 0.2, -195.74);
		BankAccount account6 = new BankAccount("38776543", "946284", "Ms F Davies", "current/checking", 0.2, -503.47);
		BankAccount account7 = new BankAccount("87609802", "987654", "Mr B Wilson", "savings", 1.1, 2.5);
		BankAccount account8 = new BankAccount("56483769", "234567", "Dr E Evans", "current/checking", 0.2, -947.72);
        
        List<BankAccount> accounts = Arrays.asList(account1,account2,account3,account4,account5,account6,account7,account8);
        
         
        int numberOfCurrentAccounts = (int) accounts.stream()
                .filter(account -> "current/checking".equals(account.getAccountType()))
                .count();

        int numberOfOverdrawnAccounts = (int) accounts.stream()
                .filter(account -> account.getBalance() < 0)
                .count();

        Double highestBalance = accounts.stream()
                .map(BankAccount::getBalance)
                .max(Double::compareTo)
                .orElse(0.0);

        double averageBalance = accounts.stream()
                .mapToDouble(BankAccount::getBalance)
                .average()
                .orElse(0.0);

        double averageBalanceInCredit = accounts.stream()
                .filter(account -> account.getBalance() < 0)
                .mapToDouble(BankAccount::getBalance)
                .average()
                .orElse(0.0);

        Double sumOfAllOverdrafts = accounts.stream()
                .filter(account -> account.getBalance() < 0)
                .mapToDouble(BankAccount::getBalance)
                .sum();

        double totalInterestDue = accounts.stream()
                .filter(account -> account.getBalance() > 0)
                .mapToDouble(account -> (account.getBalance() / 100) * account.getInterestRate())
                .sum();

        
        
        log.debug("\n " +numberOfCurrentAccounts +"\n " + numberOfOverdrawnAccounts +"\n " + highestBalance + "\n " + averageBalance+ "\n " +averageBalanceInCredit
        		+ "\n " + sumOfAllOverdrafts + "\n " +totalInterestDue+ "\n =============================END of 1.2 ======================================");
        
        
        
        
        
        
        
        List<String> overdrawnAccountHolders = accounts.stream()
        	    .filter(account -> account.getBalance() < 0)
        	    .map(BankAccount::getAccountHolder)
        	    .collect(Collectors.toList());

        //Increase the interest rate 
        	accounts.stream()
        	    .filter(account -> "savings".equals(account.getAccountType()))
        	    .forEach(account -> account.setInterestRate(1.3));
        	
        	//Replace bank code 234567
        	accounts.stream()
        	    .filter(account -> "234567".equals(account.getBankCode()))
        	    .forEach(account -> account.setBankCode("123456"));

        	List<BankAccount> bankCode987654Accounts = accounts.stream()
        	    .filter(account -> "987654".equals(account.getBankCode()))
        	    .collect(Collectors.toList());

        	List<BankAccount> drTitleAccounts = accounts.stream()
        	    .filter(account -> account.getAccountHolder().startsWith("Dr"))
        	    .collect(Collectors.toList());
        	
        	
        	
        log.info("\n " + overdrawnAccountHolders+"\n ");
        accounts.stream().filter(account -> "savings".equals(account.getAccountType()) && account.getInterestRate() == 1.3 ).forEach(log::info);
        log.info("\n \n ");
        accounts.stream().filter(account -> "123456".equals(account.getBankCode()) ).forEach(log::info);log.info("\n \n ");
        log.info("\n " + bankCode987654Accounts+"\n \n "+ drTitleAccounts+ "\n =============================END of 1.3 ======================================");
        
        
        // Find the bank account with the highest balance
        Optional<BankAccount> maxBalanceAccount = accounts.stream()
            .reduce((acc1, acc2) -> acc1.getBalance() > acc2.getBalance() ? acc1 : acc2);

        // Find the bank account with the lowest balance for sort code 987654
        Optional<BankAccount> minBalanceAccount = accounts.stream()
            .filter(account -> "987654".equals(account.getBankCode()))
            .reduce((acc1, acc2) -> acc1.getBalance() < acc2.getBalance() ? acc1 : acc2);
        
        log.info("\n \n " + maxBalanceAccount+"\n "+minBalanceAccount + "\n =============================END of 1.4 ====================================== \n");
        
        HashMap<String, Integer> spMap = new HashMap<>();
        
        accounts.stream().forEach(arg -> 	spMap.put(arg.getAccountType(),  spMap.get(arg.getAccountType()) != null ?  spMap.get(arg.getAccountType())+1 : 1));
                
        log.info(spMap);
          
        String result;

        if (spMap.values().stream().distinct().count() == 1) {result = "No max account type";} 
        else {  result = spMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No max account type");
        }
        
        log.info(result);
        
         
        
        Map<Object, Long> countTypes = accounts.stream()
        		.collect(Collectors.groupingBy(BankAccount->BankAccount.getAccountType(), Collectors.counting()));
        
        log.info(countTypes);
        
        	countTypes.forEach((type, count) ->
        	    System.out.println("Account Type: " + type + " - Count: " + count)
        	);   
	
        
        
	}

}
