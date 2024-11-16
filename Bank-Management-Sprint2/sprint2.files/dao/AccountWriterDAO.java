package dao;

import com.fdmgroup.subclasses.Account;

public interface AccountWriterDAO 
{
	public Account createAccount(Account account);
	public void deleteAccount(Account account);
}
