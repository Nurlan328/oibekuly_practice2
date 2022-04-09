package kz.iitu.itse1910.nurlan.oibekuly.service;

import kz.iitu.itse1910.nurlan.oibekuly.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

class BankServiceTest {
    @Mock
    Logger logger;
    @InjectMocks
    BankService bankService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testDeposit() {
        bankService.deposit(new Account(Long.valueOf(1), 0d, 0d), Double.valueOf(0));
    }

    @Test
    void testWithdraw() {
        bankService.withdraw(new Account(Long.valueOf(1), 0d, 0d), Double.valueOf(0));
    }
}

