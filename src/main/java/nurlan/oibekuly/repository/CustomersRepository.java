package nurlan.oibekuly.repository;

import nurlan.oibekuly.model.Customers;

import java.util.List;

public interface CustomersRepository  {
    List<Customers> findAll();
    Customers findById(Integer id);
    Customers save(Customers customers);
    void delete(int id);
}
