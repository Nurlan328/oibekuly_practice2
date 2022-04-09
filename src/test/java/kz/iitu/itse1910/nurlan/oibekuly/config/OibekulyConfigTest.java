package kz.iitu.itse1910.nurlan.oibekuly.config;

import org.aspectj.lang.JoinPoint;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;

import static org.mockito.Mockito.*;

class OibekulyConfigTest {
    @Mock
    ApplicationContext applicationContext;
    @Mock
    JoinPoint joinPoint;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    void testMain() {
//         OibekulyConfig.main(new String[]{"args"});
//    }
}

