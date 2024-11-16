package lambdaExercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 * @author Administrator
 */

public class Runner 
{
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

        
        
        //String aaresult = account3 -> account.getAccountHolder() + ": " + account.getBalance();
        // 1. Function to return account holder and balance
        Function<BankAccount, String> accountHolderAndBalance = account -> account.getAccountHolder() + ": " + account.getBalance();
        System.out.println(accountHolderAndBalance.apply(account3)); // "Dr T Williams: 4763.32"
        System.out.println(accountHolderAndBalance.apply(account4)); // "Ms S Taylor: 10598.01"

        // 2. Function to calculate interest due
        Function<BankAccount, Double> interestDue = account -> account.getBalance() * account.getInterestRate() / 100;
        System.out.println(interestDue.apply(account2)); // 1.1

        // 3. Function to calculate interest due with 0 if overdrawn
        Function<BankAccount, Double> interestDueWithCheck = account -> account.getBalance() > 0 ? account.getBalance() * account.getInterestRate() / 100 : 0.0;
        System.out.println(interestDueWithCheck.apply(account2)); // 1.1
        System.out.println(interestDueWithCheck.apply(account8)); // 0.0

        // 4. Predicate to check if the account is a current account
        Predicate<BankAccount> isCurrentAccount = account -> "current/checking".equals(account.getAccountType());
        System.out.println(isCurrentAccount.test(account1)); // false
        System.out.println(isCurrentAccount.test(account6)); // true

        // 5. Predicate to check if the account is overdrawn
        Predicate<BankAccount> isOverdrawn = account -> account.getBalance() < 0;
        System.out.println(isOverdrawn.test(account5)); // true
        System.out.println(isOverdrawn.test(account7)); // false

        // 6. BinaryOperator to return the account with the highest balance
        BinaryOperator<BankAccount> highestBalance = (accountA, accountB) -> accountA.getBalance() > accountB.getBalance() ? accountA : accountB;
        System.out.println(highestBalance.apply(account3, account4)); // account4

        // 7. Consumer to deduct a £10 fee
        Consumer<BankAccount> deductFee = account -> account.setBalance(account.getBalance() - 10);
        deductFee.accept(account2);
        deductFee.accept(account6);
        System.out.println(account2.getBalance()); // 540.0
        System.out.println(account6.getBalance()); // -513.47

        // 8. BiConsumer to deduct a specific fee
        BiConsumer<BankAccount, Integer> deductSpecificFee = (account, fee) -> account.setBalance(account.getBalance() - fee);
        deductSpecificFee.accept(account1, 100);
        deductSpecificFee.accept(account5, 50);
        System.out.println(account1.getBalance()); // 25262.91
        System.out.println(account5.getBalance()); // -245.74

        // List operations
        ArrayList<BankAccount> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);
        accounts.add(account4);
        accounts.add(account5);
        accounts.add(account6);
        accounts.add(account7);
        accounts.add(account8);

        // Display account details
        accounts.forEach(account -> System.out.println(account.getAccountNumber() + " " + account.getAccountHolder() + " " + account.getAccountType() + " " + account.getBalance()));

        // Deduct £10 from each account
        accounts.forEach(deductFee);
        accounts.forEach(account -> System.out.println(account.getBalance()));

        // Remove overdrawn accounts by more than £500
        accounts.removeIf(account -> account.getBalance() < -500);
        accounts.forEach(account -> System.out.println(account.getAccountHolder() + " " + account.getBalance()));

        // Remove savings accounts
        accounts.removeIf(account -> "savings".equals(account.getAccountType()));
        accounts.forEach(account -> System.out.println(account.getAccountHolder() + " " + account.getBalance()));

        // Add accounts back
        accounts.add(account1);
        accounts.add(account3);
        accounts.add(account4);
        accounts.add(account7);

        // Sort by balance
        accounts.sort(Comparator.comparingDouble(BankAccount::getBalance));
        accounts.forEach(account -> System.out.println(account.getAccountHolder() + " " + account.getBalance()));

        // Sort by account type
        accounts.sort(Comparator.comparing(BankAccount::getAccountType));
        accounts.forEach(account -> System.out.println(account.getAccountHolder() + " " + account.getAccountType()));

        // Sort by account number
        accounts.sort(Comparator.comparing(BankAccount::getAccountNumber));
        accounts.forEach(account -> System.out.println(account.getAccountHolder() + " " + account.getAccountNumber()));

        // Sort by account type and then balance
        accounts.sort(Comparator.comparing(BankAccount::getAccountType).thenComparing(BankAccount::getBalance));
        accounts.forEach(account -> System.out.println(account.getAccountHolder() + " " + account.getAccountType() + " " + account.getBalance()));

        // Map.merge() example
        Map<Integer, Integer> accountCountByBankCode = new HashMap<>();
        accounts.forEach(account -> accountCountByBankCode.merge(Integer.parseInt(account.getBankCode()), 1, Integer::sum));
        System.out.println(accountCountByBankCode);

        Map<Integer, Double> balanceSumByBankCode = new HashMap<>();
        accounts.forEach(account -> balanceSumByBankCode.merge(Integer.parseInt(account.getBankCode()), account.getBalance(), Double::sum));
        System.out.println(balanceSumByBankCode);
    }
}
