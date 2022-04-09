package nurlan.oibekuly.config;

import nurlan.oibekuly.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
@Scope("prototype")
@PropertySource(value = "application.properties", ignoreResourceNotFound = true)
public class AccountConfig {

    private static Logger logger = LoggerFactory.getLogger(AccountConfig.class);

    @PostConstruct
    public void init() {
        logger.info("Doing my initialization");
    }

    @Autowired
    private Environment env;

    @Lazy
    @Bean
    public Account accountBean() {
        Account account = new Account();
        account.setAccountNumber(1L);
        account.setBalance(25650);
        account.setInterest(0.01);
        return account;
    }

    public void run() {
        logger.info("From Account Environment");
        logger.info("Account number: {}", env.getProperty("ac.accountNumber"));
        logger.info("Balance: {}", env.getProperty("ac.balance"));
        logger.info("Interest: {}", env.getProperty("ac.interest"));
    }

    @PreDestroy
    public void destroy() {
        logger.info("Doing my destruction");
    }
}
