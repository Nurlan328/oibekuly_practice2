package kz.iitu.itse1910.nurlan.oibekuly.repository;

import kz.iitu.itse1910.nurlan.oibekuly.model.Account;
import kz.iitu.itse1910.nurlan.oibekuly.model.Customers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class JdbcCustomersRepositoryTest {
    @Mock
    JdbcTemplate jdbcTemplate;
    @InjectMocks
    JdbcCustomersRepository jdbcCustomersRepository;
    @Autowired
    ResultSet rs;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAll() {
        Iterable<Customers> result = jdbcCustomersRepository.findAll();
        Assertions.assertNotEquals(null, result);
    }

    @Test
    void testFindOne() {
        Customers result = jdbcCustomersRepository.findOne(Integer.valueOf(0));
        Assertions.assertNotEquals(new Customers(Integer.valueOf(0), "firstname", "lastname", 0, "address", new Account(Long.valueOf(1), 0d, 0d)), result);
    }

    @Test
    void testSave() {
        Customers result = jdbcCustomersRepository.save(new Customers(Integer.valueOf(0), "firstname", "lastname", 0, "address", new Account(Long.valueOf(1), 0d, 0d)));
        Assertions.assertNotEquals(new Customers(Integer.valueOf(0), "firstname", "lastname", 0, "address", new Account(Long.valueOf(1), 0d, 0d)), result);
    }

    @Test
    void testMapRowToCustomer() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt((String) any())).thenReturn(1);
        when(resultSet.getString((String) any())).thenReturn("String");
        Customers actualMapRowToCustomerResult = this.jdbcCustomersRepository.mapRowToCustomer(resultSet, 10);
        assertEquals("String", actualMapRowToCustomerResult.getLastname());
        assertEquals(1, actualMapRowToCustomerResult.getId().intValue());
        assertEquals("String", actualMapRowToCustomerResult.getFirstname());
        assertEquals(1, actualMapRowToCustomerResult.getAge());
        assertEquals("String", actualMapRowToCustomerResult.getAddress());
        verify(resultSet, atLeast(1)).getInt((String) any());
        verify(resultSet, atLeast(1)).getString((String) any());
    }

    @Test
    void testMapRowToCustomer2() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt((String) any())).thenThrow(new SQLException());
        when(resultSet.getString((String) any())).thenThrow(new SQLException());
        assertThrows(SQLException.class, () -> this.jdbcCustomersRepository.mapRowToCustomer(resultSet, 10));
        verify(resultSet).getInt((String) any());
    }
}

