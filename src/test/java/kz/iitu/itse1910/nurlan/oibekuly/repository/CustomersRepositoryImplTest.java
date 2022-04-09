package kz.iitu.itse1910.nurlan.oibekuly.repository;

import kz.iitu.itse1910.nurlan.oibekuly.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CustomersRepositoryImplTest {
    @Mock
    Account account;
    @InjectMocks
    JdbcCustomersRepository jdbcCustomersRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    void testMakeWithdraw() {
//        String result = jdbcCustomersRepository.makeWithdraw(0d);
//        Assertions.assertEquals("You have withdrawn 0.0 tenge and incurred a fee of 5%\n" +
//                "Your balance: 31423.0 tenge", result);
//    }
}

