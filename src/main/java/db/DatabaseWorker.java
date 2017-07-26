package db;

import org.json.JSONException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface DatabaseWorker {

    void addPair(int uid1, int uid2, int mutualFriendId) throws SQLException, ClassNotFoundException;

    void printAll() throws SQLException, IOException, JSONException;
}
