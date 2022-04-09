package kz.iitu.itse1910.nurlan.oibekuly.repository;

import kz.iitu.itse1910.nurlan.oibekuly.model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

class JdbcAccountRepositoryTest {
    @Mock
    JdbcTemplate jdbcTemplate;
    @InjectMocks
    JdbcAccountRepository jdbcAccountRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAll() {
        Iterable<Account> result = jdbcAccountRepository.findAll();
        Assertions.assertNotEquals(null, result);
    }

//    @Test
//    void testFindOne() {
//        Account result = jdbcAccountRepository.findOne(Long.valueOf(1));
//        Assertions.assertNotEquals(new Account(Long.valueOf(1), 0d, 0d), result);
//    }

    @Test
    void testSave() {
        Account result = jdbcAccountRepository.save(new Account(Long.valueOf(1), 0d, 0d));
        Assertions.assertEquals(new Account(Long.valueOf(1), 0d, 0d), result);
    }
}

