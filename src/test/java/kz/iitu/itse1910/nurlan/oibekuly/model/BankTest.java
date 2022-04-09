package kz.iitu.itse1910.nurlan.oibekuly.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

class BankTest {
    @Mock
    List<Customers> customers;
    @InjectMocks
    Bank bank;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllBanks() {
        List<Bank> result = Bank.getAllBanks();
        Assertions.assertEquals(result, Bank.getAllBanks());
    }

//    @Test
//    void testGetAllCustomers() {
//        List<Customers> result = Bank.getAllCustomers();
//        Assertions.assertEquals(result,Bank.getAllCustomers() );
//
//    }

    @Test
    void testSetId() {
        bank.setId(Long.valueOf(1));
    }

    @Test
    void testSetBankName() {
        bank.setBankName("bankName");
    }

    @Test
    void testSetCustomerAccountNumber() {
        bank.setCustomerAccountNumber(Integer.valueOf(0));
    }

    @Test
    void testBuilder() {
        Bank.BankBuilder result = Bank.builder();
        Assertions.assertNotEquals(Bank.builder(), result);
    }
}

