package db;


import http.HttpRequest;
import org.json.JSONException;
import vars.Const;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DatabaseManager implements DatabaseWorker {
    private PreparedStatement statement;
    Connection connection = DatabaseConnection.getInstance();

    public DatabaseManager() throws SQLException, ClassNotFoundException {
    }

    @Override
    public void addPair(int uid1, int uid2, int mutualFriendId) throws SQLException, ClassNotFoundException {

        statement = connection.prepareStatement("INSERT INTO " +
                Const.MY_SQL_DB_TABLE_NAME +
                "(uid1, uid2, mutual_uid) VALUES (" + uid1 + "," + uid2 + "," + mutualFriendId + ");");
        //Log to console
        System.out.println("INSERT INTO " +
                Const.MY_SQL_DB_TABLE_NAME +
                "(uid1, uid2, mutual_uid) VALUES (" + uid1 + "," + uid2 + "," + mutualFriendId + ");");
        statement.executeUpdate();

    }

    @Override
    public void printAll() throws SQLException, IOException, JSONException {
        statement = connection.prepareStatement("SELECT * FROM " + Const.MY_SQL_DB_TABLE_NAME + ";");
        ResultSet resultSet = statement.executeQuery();
        HttpRequest request = new HttpRequest();

        while (resultSet.next()) {
            int uid1 = resultSet.getInt(Const.MY_SQL_UID1_COLUMN);
            int uid2 = resultSet.getInt(Const.MY_SQL_UID2_COLUMN);
            int mutualUid = resultSet.getInt(Const.MY_SQL_MUTUAL_UID_COLUMN);

            System.out.println(request.getUserInfoByUid(uid1).getFullName() + " и "
                    + request.getUserInfoByUid(uid2).getFullName() +
                    " имеют общего друга " + request.getUserInfoByUid(mutualUid).getFullName());
        }

        resultSet.close();
    }
}
