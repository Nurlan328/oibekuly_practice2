package nurlan.oibekuly.repository;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import nurlan.oibekuly.model.Account;
import nurlan.oibekuly.repository.JdbcAccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JdbcAccountRepository.class, Account.class})
@ExtendWith(SpringExtension.class)
class JdbcAccountRepositoryTest {
    @Autowired
    private Account account;

    @Autowired
    private JdbcAccountRepository jdbcAccountRepository;

    @MockBean
    private JdbcTemplate jdbcTemplate;

    @Test
    void testFindAll() throws DataAccessException {
        ArrayList<Object> objectList = new ArrayList<>();
        when(this.jdbcTemplate.query((String) any(), (org.springframework.jdbc.core.RowMapper<Object>) any()))
                .thenReturn(objectList);
        List<Account> actualFindAllResult = this.jdbcAccountRepository.findAll();
        assertSame(objectList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(this.jdbcTemplate).query((String) any(), (org.springframework.jdbc.core.RowMapper<Object>) any());
    }

    @Test
    void testFindById() throws DataAccessException {
        Account account = new Account();
        account.setAccountNumber(1234567890L);
        account.setBalance(10.0);
        account.setInterest(10.0);
        when(this.jdbcTemplate.queryForObject((String) any(), (Object[]) any(),
                (org.springframework.jdbc.core.RowMapper<Account>) any())).thenReturn(account);
        assertSame(account, this.jdbcAccountRepository.findById(1234567890L));
        verify(this.jdbcTemplate).queryForObject((String) any(), (Object[]) any(),
                (org.springframework.jdbc.core.RowMapper<Account>) any());
    }

    @Test
    void testSave() throws DataAccessException {
        when(this.jdbcTemplate.update((String) any(), (Object[]) any())).thenReturn(1);

        Account account = new Account();
        account.setAccountNumber(1234567890L);
        account.setBalance(10.0);
        account.setInterest(10.0);
        assertSame(account, this.jdbcAccountRepository.save(account));
        verify(this.jdbcTemplate).update((String) any(), (Object[]) any());
    }

    @Test
    void testDelete() throws DataAccessException {
        when(this.jdbcTemplate.update((String) any(), (Object[]) any())).thenReturn(1);
        this.jdbcAccountRepository.delete(1234567890L);
        verify(this.jdbcTemplate).update((String) any(), (Object[]) any());
    }
}

