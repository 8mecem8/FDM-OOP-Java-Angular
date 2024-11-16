package com.fdmgroupDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.fdmgroupDemo.model.Account;
import com.fdmgroupDemo.service.AccountService;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerTest 
{

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    private Account testAccount;

//    @BeforeEach
//    void setUp() {
//        testAccount = new Account();
//        testAccount.setBalance(new BigDecimal("1000.00"));
//    }
//
//    @Test
//    void getAccountsByCity() throws Exception {
//        when(accountService.getAccountsByCustomerCity("Toronto")).thenReturn(Arrays.asList(testAccount));
//
//        mockMvc.perform(get("/api/v1/account/by-city")
//                .param("city", "Toronto"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void createAccount() throws Exception {
//        AccountDTO accountDTO = new AccountDTO();
//        accountDTO.setCustomerId(1L);
//        accountDTO.setType("savings");
//        accountDTO.setBalance(new BigDecimal("1000.00"));
//        accountDTO.setInterestRate(new BigDecimal("0.05"));
//
//        when(accountService.createAccount(any(AccountDTO.class))).thenReturn(testAccount);
//
//        mockMvc.perform(post("/api/v1/account")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content("{\"customerId\":1,\"type\":\"savings\",\"balance\":1000.00,\"interestRate\":0.05}"))
//                .andExpect(status().isOk());
//    }
}