package service;

import java.util.List;

import com.fdmgroup.subclasses.Account;

import dao.AccountReaderDAO;
import dao.AccountWriterDAO;

public class AccountServiceImpl implements AccountService 
{
	private AccountReaderDAO accountReaderDAO;
    private AccountWriterDAO accountWriterDAO;

    public AccountServiceImpl(AccountReaderDAO accountReaderDAO, AccountWriterDAO accountWriterDAO) 
    {
        this.accountReaderDAO = accountReaderDAO;
        this.accountWriterDAO = accountWriterDAO;
    }

	@Override
	public List<Account> getAccounts() 
	{
		return accountReaderDAO.readAccounts();
	}

	@Override
	public void removeAccount(Account account) 
	{
		accountWriterDAO.deleteAccount(account);
	}

	@Override
	public Account createAccount(Account account) 
	{
		return accountWriterDAO.createAccount(account);
	}
}
