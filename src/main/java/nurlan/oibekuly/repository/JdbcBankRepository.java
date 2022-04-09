package nurlan.oibekuly.repository;

import nurlan.oibekuly.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcBankRepository implements BankRepository {

    public JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcBankRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Bank> findAll() {
        String sql = "select * from bank";
        return  jdbcTemplate.query(sql, new BankRowMapper());
    }

    @Override
    public Bank findFindbyId(int id) {
        String sql = "select * from bank  where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BankRowMapper());
    }

    @Override
    public Bank save(Bank bank) {
        jdbcTemplate.update(
                "insert into BANK (id, bankName, customerAccountNumber) values (?, ?, ?)",
                bank.getId(),
                bank.getBankName(),
                bank.getCustomerAccountNumber()
        );
        return bank;
    }

    public void delete(int id) {
        jdbcTemplate.update("delete from bank where id = ?", id);
    }
}

class BankRowMapper implements RowMapper<Bank> {
    public Bank mapRow(ResultSet rs, int i) throws SQLException {
        Bank bank = new Bank();
        bank.setId(rs.getInt("ID"));
        bank.setBankName(rs.getString("BANKNAME"));
        bank.setCustomerAccountNumber(rs.getInt("CUSTOMERACCOUNTNUMBER"));
        return bank;
    }
}