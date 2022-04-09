package nurlan.oibekuly.service;

import nurlan.oibekuly.aop.AccountOperation;
import nurlan.oibekuly.model.Account;
import nurlan.oibekuly.model.Bank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class BankService {

    private static Logger logger = LoggerFactory.getLogger(BankService.class);

    @AccountOperation(operation = "deposit")
    public void deposit(Account account, Double amount) {
        account.setBalance(account.getBalance() + amount);
    }

    @AccountOperation(operation = "withdraw")
    public void withdraw(Account account, Double amount) {

        if (amount < 0) {
            logger.info("The withdrawn amount must exceed 1000");
        }

        account.setBalance(account.getBalance() - amount);

    }

    public String bankDetails() {
        Bank bank = new Bank();
        return "Bank id: "  + bank.getId() +
               "\n Bank name: " + bank.getBankName() +
                "\n Number of customer account " + bank.getCustomerAccountNumber();
    }
}
