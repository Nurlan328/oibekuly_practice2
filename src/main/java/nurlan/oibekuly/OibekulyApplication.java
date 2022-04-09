package nurlan.oibekuly;

import nurlan.oibekuly.aop.CustomersAspect;
import nurlan.oibekuly.model.Account;
import nurlan.oibekuly.model.Bank;
import nurlan.oibekuly.model.Customers;
import nurlan.oibekuly.repository.JdbcAccountRepository;
import nurlan.oibekuly.repository.JdbcBankRepository;
import nurlan.oibekuly.repository.JdbcCustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class OibekulyApplication {
    @Autowired
    private  static ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(OibekulyApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            CustomersAspect customersAspect = new CustomersAspect();
            System.out.println(customersAspect.makeWithdraw());

            JdbcBankRepository jdbcBankRepository = applicationContext.getBean(JdbcBankRepository.class);
            JdbcAccountRepository jdbcAccountRepository = applicationContext.getBean(JdbcAccountRepository.class);
            JdbcCustomersRepository jdbcCustomersRepository = applicationContext.getBean(JdbcCustomersRepository.class);

            Customers customers = new Customers();
            customers.setId(17);
            customers.setFirstname("Elon");
            customers.setLastname("Musk");
            customers.setAge(49);
            customers.setAddress("New York");
            jdbcCustomersRepository.save(customers);

            Customers customers1 = jdbcCustomersRepository.findById(17);
            System.out.println(customers1.toString());

            List<Customers> customersList = jdbcCustomersRepository.findAll();
            if (customersList.size() > 0) {
                customersList.forEach(customer -> {
                    System.out.println(customer.toString());
                });
            }

            jdbcCustomersRepository.delete(17);

            Account account = new Account();
            account.setAccountNumber(16L);
            account.setBalance(34567);
            account.setInterest(0.02);
            jdbcAccountRepository.save(account);

            Account account1 = jdbcAccountRepository.findById(12L);
            System.out.println(account1.toString());

            List<Account> accounts = jdbcAccountRepository.findAll();
            accounts.forEach(ac -> {
                System.out.println(ac.toString());
            });

            jdbcAccountRepository.delete(16L);

            Bank bank = new Bank();
            bank.setId(16);
            bank.setBankName("NewBank");
            bank.setCustomerAccountNumber(7410);
            jdbcBankRepository.save(bank);

            Bank bank1 = jdbcBankRepository.findFindbyId(16);
            System.out.println(bank1.toString());

            List<Bank> banks = jdbcBankRepository.findAll();
            if (banks.size() > 0) {
                banks.forEach(b -> {
                    System.out.println(b.toString());
                });
            }

            jdbcBankRepository.delete(16);
        };
    }
}
