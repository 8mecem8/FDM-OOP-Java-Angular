package streamsExercises;

public class BankAccount 
{
    private String accountNumber;
    private String bankCode;
    private String accountHolder;
    private String accountType;
    private double interestRate;
    private double balance;

    public BankAccount(String accountNumber, String bankCode, String accountHolder, String accountType, double interestRate, double balance) 
    {
        this.accountNumber = accountNumber;
        this.bankCode = bankCode;
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.interestRate = interestRate;
        this.balance = balance;
    }

    // Getters and Setters
    public String getAccountNumber() {return accountNumber;}

    public void setAccountNumber(String accountNumber) {this.accountNumber = accountNumber;}

    public String getBankCode() {return bankCode;}

    public void setBankCode(String bankCode) {this.bankCode = bankCode;}

    public String getAccountHolder() {return accountHolder;}

    public void setAccountHolder(String accountHolder) {this.accountHolder = accountHolder;}

    public String getAccountType() {return accountType;}

    public void setAccountType(String accountType) {this.accountType = accountType;}

    public double getInterestRate() {return interestRate;}

    public void setInterestRate(double interestRate) {this.interestRate = interestRate;}

    public double getBalance() {return balance;}

    public void setBalance(double balance) {this.balance = balance;}

    @Override
    public String toString() {
        return accountHolder + ": " + balance;
    }
}