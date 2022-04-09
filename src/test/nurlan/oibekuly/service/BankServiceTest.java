package nurlan.oibekuly.service;

import nurlan.oibekuly.model.Account;
import nurlan.oibekuly.service.BankService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ContextConfiguration(classes = {BankService.class})
@ExtendWith(SpringExtension.class)
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

    @Test
    void testBankDetails() {
        assertEquals("Bank id: 0\n Bank name: null\n Number of customer account 0", this.bankService.bankDetails());
    }
}

