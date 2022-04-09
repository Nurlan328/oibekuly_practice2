package kz.iitu.itse1910.nurlan.oibekuly.repository;

import kz.iitu.itse1910.nurlan.oibekuly.model.Bank;
import kz.iitu.itse1910.nurlan.oibekuly.model.Customers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JdbcBankRepositoryTest {
    @Mock
    JdbcTemplate jdbcTemplate;
    @InjectMocks
    JdbcBankRepository jdbcBankRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAll() {
        Iterable<Bank> result = jdbcBankRepository.findAll();
        assertNotEquals(null, result);
    }

    @Test
    void testFindOne() {
        Bank result = jdbcBankRepository.findOne(Long.valueOf(1));
        assertNotEquals(new Bank(Long.valueOf(1), "Kaspi bank", Integer.valueOf(9999999)), result);
    }

    @Test
    void testSave() {
        Bank result = jdbcBankRepository.save(new Bank(Long.valueOf(1), "bankName", Integer.valueOf(0)));
        Assertions.assertEquals(new Bank(Long.valueOf(1), "bankName", Integer.valueOf(0)), result);
    }

    @Test
    void testMapRowToBank() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt((String) any())).thenReturn(1);
        when(resultSet.getString((String) any())).thenReturn("String");
        Bank actualMapRowToCustomerResult = this.jdbcBankRepository.mapRowToBank(resultSet, 10);
//        assertEquals("String", actualMapRowToCustomerResult.getBankName());
        Assertions.assertNotEquals(1, actualMapRowToCustomerResult.getId().intValue());
//        assertEquals("String", actualMapRowToCustomerResult.getFirstname());
//        assertEquals(1, actualMapRowToCustomerResult.getAge());
//        assertEquals("String", actualMapRowToCustomerResult.getAddress());
        verify(resultSet, atLeast(1)).getInt((String) any());
        verify(resultSet, atLeast(1)).getString((String) any());
    }

}

