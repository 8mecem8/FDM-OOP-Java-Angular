package sprint3;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fdmgroup.subclasses.Account;
import com.fdmgroup.subclasses.Customer;

import jakarta.mail.MessagingException;
import service.AlertService;
import util.EmailUtil;






@ExtendWith(MockitoExtension.class)
class AlertServiceTest {

    @Mock
    private EmailUtil emailUtil;

    @InjectMocks
    private AlertService alertService;

    private Customer customer;
    private Account account;

    @BeforeEach
    void setUp() {
        customer = mock(Customer.class);
        account = mock(Account.class);

        when(customer.getName()).thenReturn("John Doe");
        when(customer.getEmail()).thenReturn("john.doe@example.com");
        when(account.getACCOUNT_ID()).thenReturn(123456789L);
        when(account.getBalance()).thenReturn(1000.0);
    }

    @Test
    void testSendTransactionAlert() throws MessagingException {
        alertService.sendTransactionAlert(customer, account, 200.0);

        verify(emailUtil, times(1)).sendEmail(eq("john.doe@example.com"), eq("Transaction Alert"),
                contains("Transaction Details"));
    }

    @Test
    void testSendBalanceViolationAlert() throws MessagingException {
        alertService.sendBalanceViolationAlert(customer, account);

        verify(emailUtil, times(1)).sendEmail(eq("john.doe@example.com"), eq("Balance Violation Alert"),
                contains("account balance is below the minimum required balance"));
    }

    
   

 
}
