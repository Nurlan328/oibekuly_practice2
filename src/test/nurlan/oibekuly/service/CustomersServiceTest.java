package nurlan.oibekuly.service;

import nurlan.oibekuly.model.Account;
import nurlan.oibekuly.repository.CustomersRepository;
import nurlan.oibekuly.repository.JdbcCustomersRepository;
import nurlan.oibekuly.service.CustomersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

class CustomersServiceTest {
    @Mock
    CustomersRepository customersRepository;
    @Mock
    JdbcCustomersRepository jdbcCustomersRepository;
    @Mock
    Logger logger;
    @Mock
    Account account;
    @InjectMocks
    CustomersService customersService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testgetBalance() {
        double res = customersService.getBalance();
        Assertions.assertEquals(res, customersService.getBalance());
    }

    @Test
    void testMakeWithdraw() {
        String result = customersService.makeWithdraw(0d);
        Assertions.assertEquals(customersService.makeWithdraw(0d), result);
    }
}

