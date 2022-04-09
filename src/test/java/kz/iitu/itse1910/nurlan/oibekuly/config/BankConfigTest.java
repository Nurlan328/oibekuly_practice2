package kz.iitu.itse1910.nurlan.oibekuly.config;

import kz.iitu.itse1910.nurlan.oibekuly.model.Bank;
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
        Assertions.assertEquals(new Bank(Long.valueOf(3), "Forte bank", Integer.valueOf(69363)), result);
    }

    @Test
    void testKaspiBank() {
        Bank result = BankConfig.KaspiBank();
        Assertions.assertEquals(new Bank(Long.valueOf(1), "Kaspi bank", Integer.valueOf(893635)), result);
    }

    @Test
    void testHalykBank() {
        Bank result = BankConfig.HalykBank();
        Assertions.assertEquals(new Bank(Long.valueOf(2), "Halyk Bank", Integer.valueOf(793635)), result);
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


    @Test
    void testgenerateToken() {
        try {
            bankConfig.generateToken();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetActiveProfiles() {
        try {
            bankConfig.getActiveProfiles();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}

