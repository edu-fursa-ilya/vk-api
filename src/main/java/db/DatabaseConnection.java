package db;

import vars.Const;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
  private static Connection connection = null;

    public static Connection getInstance() throws ClassNotFoundException, SQLException {
        if(connection == null) {
            Class.forName(Const.MY_SQL_DB_DRIVER);
            connection = DriverManager.getConnection(Const.MY_SQL_DB_URL, Const.MY_SQL_DB_USER, Const.MY_SQL_DB_PASSWORD);
        }

        return connection;
    }

    private DatabaseConnection() {

    }
}
