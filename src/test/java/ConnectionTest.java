import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConnectionTest {
    @Test
    void testConnection() throws Exception {
        Properties props = new Properties();
        props.load(getClass().getClassLoader().getResourceAsStream("db.properties"));

        String driver = props.getProperty("db.driver");
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        Class.forName(driver);

        Connection conn = DriverManager.getConnection(url, user, password);

        assertNotNull(conn);
        conn.close();
    }
}

