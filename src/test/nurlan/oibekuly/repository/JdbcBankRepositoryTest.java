package nurlan.oibekuly.repository;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import nurlan.oibekuly.model.Bank;
import nurlan.oibekuly.repository.JdbcBankRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JdbcBankRepository.class, Bank.class})
@ExtendWith(SpringExtension.class)
class JdbcBankRepositoryTest {
    @Autowired
    private Bank bank;

    @Autowired
    private JdbcBankRepository jdbcBankRepository;

    @MockBean
    private JdbcTemplate jdbcTemplate;

    @Test
    void testFindAll() throws DataAccessException {
        ArrayList<Bank> bankList = new ArrayList<>();
        when(this.jdbcTemplate.query((String) any(), (org.springframework.jdbc.core.RowMapper<Bank>) any()))
                .thenReturn(bankList);
        List<Bank> actualFindAllResult = this.jdbcBankRepository.findAll();
        assertSame(bankList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(this.jdbcTemplate).query((String) any(), (org.springframework.jdbc.core.RowMapper<Bank>) any());
    }

    @Test
    void testFindFindbyId() throws DataAccessException {
        Bank bank = new Bank();
        bank.setBankName("Forte Bank");
        bank.setCustomerAccountNumber(3);
        bank.setId(1);
        when(this.jdbcTemplate.queryForObject((String) any(), (Object[]) any(),
                (org.springframework.jdbc.core.RowMapper<Bank>) any())).thenReturn(bank);
        assertSame(bank, this.jdbcBankRepository.findFindbyId(1));
        verify(this.jdbcTemplate).queryForObject((String) any(), (Object[]) any(),
                (org.springframework.jdbc.core.RowMapper<Bank>) any());
        assertTrue(this.jdbcBankRepository.findAll().isEmpty());
    }

    @Test
    void testSave() throws DataAccessException {
        when(this.jdbcTemplate.update((String) any(), (Object[]) any())).thenReturn(1);

        Bank bank = new Bank();
        bank.setBankName("Halyk Bank");
        bank.setCustomerAccountNumber(3);
        bank.setId(1);
        assertSame(bank, this.jdbcBankRepository.save(bank));
        verify(this.jdbcTemplate).update((String) any(), (Object[]) any());
        assertTrue(this.jdbcBankRepository.findAll().isEmpty());
    }

    @Test
    void testDelete() throws DataAccessException {
        when(this.jdbcTemplate.update((String) any(), (Object[]) any())).thenReturn(1);
        this.jdbcBankRepository.delete(1);
        verify(this.jdbcTemplate).update((String) any(), (Object[]) any());
        assertTrue(this.jdbcBankRepository.findAll().isEmpty());
    }
}

