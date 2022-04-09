package nurlan.oibekuly.repository;

import nurlan.oibekuly.model.Account;

import java.util.List;

public interface AccountRepository {
    public List<Account> findAll();
    Account findById(Long id);
    Account save(Account account);
    void delete(Long accountNumber);
}
