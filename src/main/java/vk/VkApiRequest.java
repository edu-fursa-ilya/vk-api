package vk;


import org.json.JSONException;
import pojo.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface VkApiRequest {

    User getUserInfoByUid(int uid) throws IOException, JSONException;

    String getCityById(int cityId) throws IOException, JSONException;

    List<String> getMutualFriends(int sourceId, int targetId) throws IOException, SQLException, ClassNotFoundException;

    String getCountryById(int countryId) throws IOException, JSONException;

}
