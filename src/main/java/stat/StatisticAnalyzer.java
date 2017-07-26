package stat;

import http.HttpRequest;
import org.json.JSONException;
import pojo.User;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class StatisticAnalyzer implements Analyzer {
    private HttpRequest httpRequest;

    @Override
    public int getMaleCount(List<String> ids) throws IOException, JSONException {
        int maleCounter = 0;
        httpRequest = new HttpRequest();
        for (int i = 0; i < ids.size(); i++) {
            User user = getUserObject(Integer.parseInt(ids.get(i)));
            if(user.getSex() == 2) {
                maleCounter++;
            }
        }

        return maleCounter;
    }

    @Override
    public int getFemaleCount(List<String> ids) throws IOException, JSONException {
        int femaleCounter = 0;
        httpRequest = new HttpRequest();
        for (int i = 0; i < ids.size(); i++) {
            User user = getUserObject(Integer.parseInt(ids.get(i)));
            if(user.getSex() == 1) {
                femaleCounter++;
            }
        }

        return femaleCounter;
    }

    @Override
    public Map<String, Integer> getCityCounter(List<String> ids) {
        return null;
    }

    @Override
    public int getAverageAge(List<String> ids) {
        return 0;
    }

    @Override
    public User getUserObject(int uid) throws IOException, JSONException {
        httpRequest = new HttpRequest();
        return httpRequest.getUserInfoByUid(uid);
    }

    @Override
    public int getMutualFriendsCount(List<String> ids) {
        return ids.size();
    }

    @Override
    public void printAll(List<String> ids, int uid1, int uid2) throws IOException, JSONException {
        System.out.println("[!] Статистика по данным");
        System.out.println("[+] Всего муж: " + getMaleCount(ids));
        System.out.println("[+] Всего жен: " + getFemaleCount(ids));
        System.out.println("[+] Общих друзей между "
                + getUserObject(uid1).getFullName() + " и "
                + getUserObject(uid2).getFullName() + " найдено "
                + getMutualFriendsCount(ids));

    }
}
