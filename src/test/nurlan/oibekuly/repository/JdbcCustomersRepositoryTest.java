package nurlan.oibekuly.repository;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import nurlan.oibekuly.model.Customers;
import nurlan.oibekuly.repository.JdbcCustomersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JdbcCustomersRepository.class, Customers.class})
@ExtendWith(SpringExtension.class)
class JdbcCustomersRepositoryTest {
    @Autowired
    private Customers customers;

    @Autowired
    private JdbcCustomersRepository jdbcCustomersRepository;

    @MockBean
    private JdbcTemplate jdbcTemplate;

    @Test
    void testFindById() throws DataAccessException {
        Customers customers = new Customers();
        customers.setAddress("42 Main St");
        customers.setAge(1);
        customers.setFirstname("Jane");
        customers.setId(1);
        customers.setLastname("Doe");
        when(this.jdbcTemplate.queryForObject((String) any(), (Object[]) any(),
                (org.springframework.jdbc.core.RowMapper<Customers>) any())).thenReturn(customers);
        assertSame(customers, this.jdbcCustomersRepository.findById(1));
        verify(this.jdbcTemplate).queryForObject((String) any(), (Object[]) any(),
                (org.springframework.jdbc.core.RowMapper<Customers>) any());
        assertTrue(this.jdbcCustomersRepository.findAll().isEmpty());
    }

    @Test
    void testFindAll() throws DataAccessException {
        ArrayList<Customers> customersList = new ArrayList<>();
        when(this.jdbcTemplate.query((String) any(), (org.springframework.jdbc.core.RowMapper<Customers>) any()))
                .thenReturn(customersList);
        List<Customers> actualFindAllResult = this.jdbcCustomersRepository.findAll();
        assertSame(customersList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(this.jdbcTemplate).query((String) any(), (org.springframework.jdbc.core.RowMapper<Customers>) any());
    }

    @Test
    void testSave() throws DataAccessException {
        when(this.jdbcTemplate.update((String) any(), (Object[]) any())).thenReturn(1);

        Customers customers = new Customers();
        customers.setAddress("42 Main St");
        customers.setAge(1);
        customers.setFirstname("Jane");
        customers.setId(1);
        customers.setLastname("Doe");
        assertSame(customers, this.jdbcCustomersRepository.save(customers));
        verify(this.jdbcTemplate).update((String) any(), (Object[]) any());
        assertTrue(this.jdbcCustomersRepository.findAll().isEmpty());
    }

    @Test
    void testDelete() throws DataAccessException {
        when(this.jdbcTemplate.update((String) any(), (Object[]) any())).thenReturn(1);
        this.jdbcCustomersRepository.delete(1);
        verify(this.jdbcTemplate).update((String) any(), (Object[]) any());
        assertTrue(this.jdbcCustomersRepository.findAll().isEmpty());
    }
}

