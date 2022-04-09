package kz.iitu.itse1910.nurlan.oibekuly.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

class CustomersTest {
    @Mock
    List<Customers> customersList;
    @InjectMocks
    Customers customers;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    void testCustomerBuilder() {
//        final Customers.CustomersBuilder result = Customers.builder();
//    }

//    @Test
//    void testAllGetCustomers() {
//        final List<Customers> result = Customers.getAllCustomers();
//        Assertions.assertNotEquals(Collections.<Customers>singletonList(new Customers()), result.toString());
//    }


}

