package stat;

import org.json.JSONException;
import pojo.User;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface Analyzer {

    int getMaleCount(List<String> ids) throws IOException, JSONException;

    int getFemaleCount(List<String> ids) throws IOException, JSONException;

    Map<String, Integer> getCityCounter(List<String> ids);

    int getAverageAge(List<String> ids);

    User getUserObject(int uid) throws IOException, JSONException;

    int getMutualFriendsCount(List<String> ids);

    void printAll(List<String> ids, int uid1, int uid2) throws IOException, JSONException;
}
