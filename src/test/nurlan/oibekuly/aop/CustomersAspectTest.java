package nurlan.oibekuly.aop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import nurlan.oibekuly.aop.CustomersAspect;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomersAspect.class})
@ExtendWith(SpringExtension.class)
class CustomersAspectTest {
    CustomersAspect customersAspect = new CustomersAspect();

    @Test
    void testGetNameSurname() {
        customersAspect.getNameSurname();
    }

    @Test
    void testGetLastName() {
        customersAspect.getLastName();
    }

    @Test
    void testGetFirstname() {
        assertNull(this.customersAspect.getFirstname());
    }

    @Test
    void testMakeWithdraw() {
        Assertions.assertEquals("You have insufficient funds.",
                this.customersAspect.makeWithdraw());
    }

    @Test
    void testAccountDetails() {
        Assertions.assertNotEquals("Account information: \nAccount number: 142\nBalance: 31425.0\nInterest: 0.01\n",
                this.customersAspect.accountDetails());
    }

}

