package http;

import db.DatabaseManager;
import db.DatabaseWorker;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pojo.User;
import vars.Const;
import vk.VkApiRequest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HttpRequest implements VkApiRequest {


    private Request request;
    private OkHttpClient okHttpClient;
    private Response response;

    public User getUserInfoByUid(int uid) throws IOException, JSONException {
        String userInfoRequest = "https://api.vk.com/method/users.get?uid=";
        String fields = "&fields=sex,education,city,bdate,status&version=5.67";

        okHttpClient = new OkHttpClient();
        request = new Request.Builder()
                .url(userInfoRequest + uid + fields)
                .build();

        response = okHttpClient.newCall(request).execute();

        String userInfoResponseJson = response.body().string();
        User user = null;
        JSONObject userJsonObject = new JSONObject(userInfoResponseJson.toString());
        JSONArray userJsonArray = userJsonObject.getJSONArray("response");

        for (int i = 0; i < userJsonArray.length(); i++) {
            JSONObject jsonObject = userJsonArray.getJSONObject(i);

            user = new User();
            user.setUid(jsonObject.getInt("uid"));

            if (jsonObject.has("first_name") && jsonObject.has("last_name")) {
                user.setFullName(jsonObject.getString("first_name") + " " + jsonObject.getString("last_name"));
            } else user.setFullName("Unknown");

            if (jsonObject.has("sex")) {
                user.setSex(jsonObject.getInt("sex"));
            } else user.setSex(-1);

            if (jsonObject.has("bdate")) {
                user.setBirthday(jsonObject.getString("bdate"));
            } else user.setBirthday("Unknown");

            if (jsonObject.has("city")) {
                user.setCity(getCityById(jsonObject.getInt("city")));
            } else user.setCity("Unknown");

            if (jsonObject.has("university_name")) {
                user.setUniversityName(jsonObject.getString("university_name"));
            } else user.setUniversityName("Unknown");

            if (jsonObject.has("faculty_name")) {
                user.setFaculty(jsonObject.getString("faculty_name"));
            } else user.setFaculty("Unknown");

            if (jsonObject.has("graduation")) {
                user.setGraduation(jsonObject.getInt("graduation"));
            } else user.setGraduation(-1);

            if (jsonObject.has("education_status")) {
                user.setEducationStatus(jsonObject.getString("education_status"));
            } else user.setEducationStatus("Unknown");

            if (jsonObject.has("status")) {
                user.setStatus(jsonObject.getString("status"));
            } else user.setStatus("");
        }


        return user;
    }

    public String getCityById(int cityId) throws IOException, JSONException {
        String cityRequest = "https://api.vk.com/method/database.getCitiesById?city_ids=";

        okHttpClient = new OkHttpClient();
        request = new Request.Builder()
                .url(cityRequest + cityId)
                .build();

        response = okHttpClient.newCall(request).execute();

        String cityResponseJson = response.body().string();
        String city = null;
        JSONObject cityResponseObject = new JSONObject(cityResponseJson.toString());
        JSONArray cityJsonArray = cityResponseObject.getJSONArray("response");

        for (int i = 0; i < cityJsonArray.length(); i++) {
            JSONObject jsonObject = cityJsonArray.getJSONObject(i);
            city = jsonObject.getString("name");
        }

        return city;
    }

    public List<String> getMutualFriends(int sourceId, int targetId) throws IOException, SQLException, ClassNotFoundException {
        String request = "https://api.vk.com/method/friends.getMutual?source_uid="
                + sourceId + "&target_uid=" + targetId +
                "&access_token=" + Const.VK_API_TOKEN;

        OkHttpClient okHttpClient = new OkHttpClient();

        Request httpRequest = new Request.Builder()
                .url(request)
                .build();

        Response response = okHttpClient.newCall(httpRequest).execute();
        String answer = response.body().string();
        List<String> ids = new ArrayList<String>(Arrays.asList(answer.replaceAll("\\D+", " ").trim().split(" ")));

        DatabaseManager manager = new DatabaseManager();

        for (int i = 0; i < ids.size(); i++) {
            manager.addPair(sourceId, targetId, Integer.parseInt(ids.get(i)));
        }

        return ids;
    }

    public String getCountryById(int countryId) throws IOException, JSONException {
        String cityRequest = "https://api.vk.com/method/database.getCountriesById?country_ids=";

        okHttpClient = new OkHttpClient();
        request = new Request.Builder()
                .url(cityRequest + countryId)
                .build();

        response = okHttpClient.newCall(request).execute();

        String countryResponseJson = response.body().string();
        String country = null;
        JSONObject cityResponseObject = new JSONObject(countryResponseJson.toString());
        JSONArray cityJsonArray = cityResponseObject.getJSONArray("response");

        for (int i = 0; i < cityJsonArray.length(); i++) {
            JSONObject jsonObject = cityJsonArray.getJSONObject(i);
            country = jsonObject.getString("name");
        }

        return country;
    }


}
