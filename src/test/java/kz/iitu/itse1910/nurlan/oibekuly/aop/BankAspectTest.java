package kz.iitu.itse1910.nurlan.oibekuly.aop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import kz.iitu.itse1910.nurlan.oibekuly.model.Bank;
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

    @Test
    void testListOffBanks() {
        List<Bank> actualListOffBanksResult = this.bankAspect.listOffBanks();
        assertEquals(2, actualListOffBanksResult.size());
        Bank getResult = actualListOffBanksResult.get(1);
        assertEquals(2L, getResult.getId().longValue());
        assertEquals(9999999, getResult.getCustomerAccountNumber().intValue());
        assertEquals("Halyk Bank", getResult.getBankName());
        Bank getResult1 = actualListOffBanksResult.get(0);
        assertEquals(1L, getResult1.getId().longValue());
        assertEquals(9999999, getResult1.getCustomerAccountNumber().intValue());
        assertEquals("Kaspi bank", getResult1.getBankName());
    }

    @Test
    void testBankDetails() {
        assertEquals("Bank id: 1\n Bank name: Kaspi Bank\n Number of customer account 65432",
                this.bankAspect.bankDetails());
    }
}

