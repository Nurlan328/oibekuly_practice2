package nurlan.oibekuly.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
@Scope("singleton")
@PropertySource(value = "application.properties", ignoreResourceNotFound = true)
public class CustomersConfig {

    private static Logger logger = LoggerFactory.getLogger(CustomersConfig.class);

    @PostConstruct
    public void init() {
        logger.info("Doing my initialization");
    }

    @Autowired
    private Environment env;

    public void run() {
        logger.info("From Customer Environment");
        logger.info("Customer id: {}", env.getProperty("customer.id"));
        logger.info("Customer name: {}", env.getProperty("customer.firstname"));
        logger.info("Customer lastname: {}", env.getProperty("customer.lastname"));
        logger.info("Age of customer : {}", env.getProperty("customer.age"));
        logger.info("Address of customer : {}", env.getProperty("customer.address"));
    }

    @PreDestroy
    public void destroy() {
        logger.info("Doing my destruction");
    }
}
