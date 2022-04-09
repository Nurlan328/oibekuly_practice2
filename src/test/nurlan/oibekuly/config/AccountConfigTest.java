package nurlan.oibekuly.config;

import nurlan.oibekuly.config.AccountConfig;
import nurlan.oibekuly.model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.core.env.Environment;

class AccountConfigTest {
    @Mock
    Logger logger;
    @Mock
    Environment env;
    @InjectMocks
    AccountConfig accountConfig;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testInit() {
        accountConfig.init();
    }

    @Test
    void testAccountBean() {
        Account result = accountConfig.accountBean();
        Assertions.assertEquals(accountConfig.accountBean(), result);
    }

    @Test
    void testRun() {
        accountConfig.run();
    }

    @Test
    void testDestroy() {
        accountConfig.destroy();
    }
}

