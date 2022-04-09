package nurlan.oibekuly.config;

import nurlan.oibekuly.model.Bank;
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
public class BankConfig {

    private static Logger logger = LoggerFactory.getLogger(BankConfig.class);

    @PostConstruct
    public void init() {
        logger.info("Doing my initialization");
    }

    @Autowired
    private Environment env;

    @Lazy
    @Bean("Forte bank")
    @DependsOn(value = {
            "Halyk Bank",
            "Kaspi bank"
    })
    public static Bank ForteBank() {
        Bank ForteBank = new Bank();
        ForteBank.setId(3);
        ForteBank.setBankName("Forte bank");
        ForteBank.setCustomerAccountNumber(69363);
        return ForteBank;
    }

    @Lazy
    @Bean("Kaspi bank")
    public static Bank KaspiBank() {
        Bank KaspiBank = new Bank();
        KaspiBank.setId(1);
        KaspiBank.setBankName("Kaspi bank");
        KaspiBank.setCustomerAccountNumber(893635);
        return KaspiBank;
    }

    @Lazy
    @Bean("Halyk Bank")
    public static Bank HalykBank() {
        Bank HalykBank = new Bank();
        HalykBank.setId(2);
        HalykBank.setBankName("Halyk Bank");
        HalykBank.setCustomerAccountNumber(793635);
        return HalykBank;
    }

    public void run() {
        logger.info("From Bank Environment");
        logger.info("Bank id: {}", env.getProperty("bank.id"));
        logger.info("Bank name: {}", env.getProperty("bank.bankName"));
        logger.info("Number of customer: {}", env.getProperty("bank.customerAccountNumber"));
    }

    @PreDestroy
    public void destroy() {
        logger.info("Doing my destruction");
    }

}
