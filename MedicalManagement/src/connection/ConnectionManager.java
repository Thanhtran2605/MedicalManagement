package connection;

import java.sql.Connection;

public abstract class ConnectionManager {
    public abstract Connection getConnection();
}
