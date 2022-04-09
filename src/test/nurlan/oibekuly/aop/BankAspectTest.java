package nurlan.oibekuly.aop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import nurlan.oibekuly.aop.BankAspect;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BankAspect.class})
@ExtendWith(SpringExtension.class)
class BankAspectTest {

    @Autowired
    private BankAspect bankAspect;

//    @Test
//    void testListOffBanks() {
//        List<Bank> actualListOffBanksResult = this.bankAspect.listOffBanks();
//        assertEquals(2, actualListOffBanksResult.size());
//        Bank getResult = actualListOffBanksResult.get(1);
//        assertEquals(2, getResult.getId());
//        assertEquals(9999999, getResult.getCustomerAccountNumber());
//        assertEquals("Halyk Bank", getResult.getBankName());
//        Bank getResult1 = actualListOffBanksResult.get(0);
//        assertEquals(1, getResult1.getId());
//        assertEquals(9999999, getResult1.getCustomerAccountNumber());
//        assertEquals("Kaspi bank", getResult1.getBankName());
//    }

    @Test
    void testBankDetails() {
        assertEquals("Bank id: 0\n Bank name: null\n Number of customer account 0", this.bankAspect.bankDetails());
    }
}

