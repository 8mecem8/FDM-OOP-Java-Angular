package service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fdmgroup.subclasses.Account;

import dao.AccountReaderDAO;
import dao.AccountWriterDAO;

class AccountServiceImplTest {

		AccountReaderDAO accountReaderDAO;AccountWriterDAO accountWriterDAO;AccountService service;Account account;
	
		@BeforeEach
		void SetUp() 
		{
			accountReaderDAO = mock(AccountReaderDAO.class);
			accountWriterDAO = mock(AccountWriterDAO.class);
			service = new AccountServiceImpl(accountReaderDAO, accountWriterDAO);
			account = new Account();
		}
	
		@Test
	    void testGetAccounts() 
		{
	        List<Account> accounts = Arrays.asList(new Account(), new Account());
	        when(accountReaderDAO.readAccounts()).thenReturn(accounts);

	      
	        assertEquals(accounts, service.getAccounts());
	    }

	    @Test
	    void testCreateAccount() 
	    {
	        service.createAccount(account);

	        verify(accountWriterDAO).createAccount(account);
	    }

	    @Test
	    void testRemoveAccount() 
	    {
	        
	        service.removeAccount(account);

	        verify(accountWriterDAO).deleteAccount(account);
	    }

}
