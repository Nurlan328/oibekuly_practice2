package nurlan.oibekuly.repository;

import nurlan.oibekuly.model.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcCustomersRepository implements CustomersRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcCustomersRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Customers findById(Integer id) {
        String sql = "select * from customers  where id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CustomersRowMapper());
    }

    public List<Customers> findAll() {
        String sql = "select * from customers";
        return jdbcTemplate.query(sql, new CustomersRowMapper());
    }

    @Override
    public Customers save(Customers customers) {
        jdbcTemplate.update(
                "insert into Customers (id, firstname, lastname, age, address) values (?, ?, ?, ?, ?)",
                customers.getId(),
                customers.getFirstname(),
                customers.getLastname(),
                customers.getAge(),
                customers.getAddress()
        );
        return customers;
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from customers where id = ?", id);
    }
}

class CustomersRowMapper implements RowMapper<Customers> {
    public Customers mapRow(ResultSet rs, int i) throws SQLException {
        Customers customers = new Customers();
        customers.setId(rs.getInt("ID"));
        customers.setFirstname(rs.getString("FIRSTNAME"));
        customers.setLastname(rs.getString("LASTNAME"));
        customers.setAge(rs.getInt("AGE"));
        customers.setAddress(rs.getString("ADDRESS"));
        return customers;
    }
}