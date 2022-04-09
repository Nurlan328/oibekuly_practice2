package nurlan.oibekuly.model;

import nurlan.oibekuly.model.Account;
import org.junit.jupiter.api.Test;

class AccountTest {

    Account account = new Account(1L, 31423d, 0.05d);

    @Test
    void testBuilder() {
        Account.AccountBuilder result = Account.builder();
//        Assertions.assertEquals(new Account(31423d, 0.05d, Long.valueOf(1)).new AccountBuilder(), result);
    }

    @Test
    void testSetBalance() {
        account.setBalance(0d);
    }

    @Test
    void testSetInterest() {
        account.setInterest(0d);
    }

    @Test
    void testSetAccountNumber() {
        account.setAccountNumber(Long.valueOf(1));
    }
}
