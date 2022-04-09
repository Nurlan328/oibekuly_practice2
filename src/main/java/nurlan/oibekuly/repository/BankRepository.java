package nurlan.oibekuly.repository;

import nurlan.oibekuly.model.Bank;

import java.util.List;

public interface BankRepository {
    List<Bank> findAll();
    Bank save(Bank bank);
    Bank findFindbyId(int id);
    void delete(int id);
}
