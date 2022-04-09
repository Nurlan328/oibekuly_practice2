package kz.iitu.itse1910.nurlan.oibekuly.aop;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    void testMakeWithdraw() {
        Assertions.assertEquals("You have withdrawn 10000.0 tenge and incurred a fee of 5%\nYour balance: 20925.0 tenge",
                this.customersAspect.makeWithdraw());
    }

    @Test
    void testAccountDetails() {
        Assertions.assertNotEquals("Account information: \nAccount number: 142\nBalance: 31425.0\nInterest: 0.01\n",
                this.customersAspect.accountDetails());
    }

}

