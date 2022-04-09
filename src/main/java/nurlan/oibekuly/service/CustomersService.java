package nurlan.oibekuly.service;

import nurlan.oibekuly.model.Account;
import nurlan.oibekuly.repository.CustomersRepository;
import nurlan.oibekuly.repository.JdbcCustomersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomersService {

    @Autowired
    private CustomersRepository customersRepository;

    @Autowired
    private JdbcCustomersRepository jdbcCustomersRepository;

    private static Logger logger = LoggerFactory.getLogger(CustomersService.class);

    Account account = new Account();
    double balance = account.getBalance();

    public double getBalance() {
        return balance;
    }

    public String makeWithdraw (double amount) {

        if (amount > balance) {
            return "You have insufficient funds.";
        } else {
            balance = balance - amount - (amount * 0.05);
            return "You have withdrawn " + amount + " tenge and incurred a fee of 5%" + "\n" +
                    "Your balance: " + balance + " tenge";
        }
    }
}
