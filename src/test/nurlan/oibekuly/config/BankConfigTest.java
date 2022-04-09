package nurlan.oibekuly.config;

import nurlan.oibekuly.config.BankConfig;
import nurlan.oibekuly.model.Bank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.core.env.Environment;

class BankConfigTest {
    @Mock
    Logger logger;
    @Mock
    Environment env;
    @InjectMocks
    BankConfig bankConfig;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testForteBank() {
        Bank result = BankConfig.ForteBank();
        Assertions.assertEquals(new Bank(3, "Forte bank", Integer.valueOf(69363)), result);
    }

    @Test
    void testKaspiBank() {
        Bank result = BankConfig.KaspiBank();
        Assertions.assertEquals(new Bank(1, "Kaspi bank", Integer.valueOf(893635)), result);
    }

    @Test
    void testHalykBank() {
        Bank result = BankConfig.HalykBank();
        Assertions.assertEquals(new Bank(2, "Halyk Bank", Integer.valueOf(793635)), result);
    }

    @Test
    void testInit() {
        bankConfig.init();
    }

    @Test
    void testDestroy() {
        bankConfig.destroy();
    }

    @Test
    void testRun() {
        bankConfig.run();
    }
}

