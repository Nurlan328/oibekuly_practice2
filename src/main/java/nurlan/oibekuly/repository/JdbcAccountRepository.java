package nurlan.oibekuly.repository;

import nurlan.oibekuly.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcAccountRepository implements AccountRepository {

    public JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcAccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Account> findAll() {
        String sql = "select * from account";
        return jdbcTemplate.query(sql, new AccountRowMapper() );
    }

    public Account findById(Long accountNumber) {
        String sql = "select * from account  where accountNumber=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{accountNumber}, new AccountRowMapper());
    }

    @Override
    public Account save(Account account) {
        jdbcTemplate.update(
                "insert into ACCOUNT (accountNumber, balance, interest) values (?, ?, ?)",
                account.getAccountNumber(),
                account.getBalance(),
                account.getInterest()
        );
        return account;
    }

    public void delete(Long accountNumber) {
        jdbcTemplate.update("delete from account where accountNumber = ?", accountNumber);
    }
}

class AccountRowMapper  implements RowMapper<Account> {
    public Account mapRow(ResultSet rs, int i) throws SQLException {
        Account account = new Account();
        account.setAccountNumber(rs.getLong("ACCOUNTNUMBER"));
        account.setBalance(rs.getDouble("BALANCE"));
        account.setInterest(rs.getDouble("INTEREST"));
        return account;
    }
}


