package kz.iitu.itse1910.nurlan.oibekuly.aop;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

class AccountAspectTest {
    @Mock
    Logger logger;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
}

