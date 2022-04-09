package kz.iitu.itse1910.nurlan.oibekuly.service;

import kz.iitu.itse1910.nurlan.oibekuly.model.Account;
import kz.iitu.itse1910.nurlan.oibekuly.repository.JdbcAccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class AccountServiceTest {
    @Mock
    JdbcAccountRepository jdbcAccountRepository;
    @Mock
    Account account;
    @InjectMocks
    AccountService accountService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testTransfer() {
        accountService.transfer(0d, new Account(Long.valueOf(1), 0d, 0d), new Account(Long.valueOf(1), 0d, 0d));
    }

    @Test
    void testMakeWithdraw() {
        String result = accountService.makeWithdraw(1);
        Assertions.assertNotEquals(accountService.makeWithdraw(1), result);
    }

    @Test
    void testAccountDetails() {
        when(account.getAccountNumber()).thenReturn(Long.valueOf(1));
        when(account.getBalance()).thenReturn(0d);
        when(account.getInterest()).thenReturn(0d);

        String result = accountService.accountDetails();
        Assertions.assertEquals(accountService.accountDetails(), result);
    }
}

