package nurlan.oibekuly.jdbc;

import static org.junit.jupiter.api.Assertions.assertTrue;

import nurlan.oibekuly.jdbc.SpringJdbcConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SpringJdbcConfig.class})
@ExtendWith(SpringExtension.class)
class SpringJdbcConfigTest {
    @Autowired
    private SpringJdbcConfig springJdbcConfig;

    @Test
    void testPostgresqlDataSource() {
        assertTrue(this.springJdbcConfig
                .postgresqlDataSource() instanceof org.springframework.jdbc.datasource.DriverManagerDataSource);
    }
}

