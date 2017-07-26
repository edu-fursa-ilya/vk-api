import db.DatabaseManager;
import http.HttpRequest;
import org.json.JSONException;
import pojo.User;
import stat.StatisticAnalyzer;


import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException, JSONException, SQLException, ClassNotFoundException {
     /*
        HttpRequest httpRequest = new HttpRequest();
        Scanner sc = new Scanner(System.in);

        System.out.print("[!]Введите uid 1 пользователя: ");
        int uid1 = sc.nextInt();
        System.out.println();

        System.out.print("[!]Введите uid 2 пользователя: ");
        int uid2 = sc.nextInt();
        System.out.println();

        System.out.println("[+]Получен пользователь: " + httpRequest.getUserInfoByUid(uid1).getFullName());
        System.out.println("[+]Получен пользователь: " + httpRequest.getUserInfoByUid(uid2).getFullName());
        System.out.println();
        System.out.println();

        System.out.println("[!]Общие друзья...");

        List<String> ids = httpRequest.getMutualFriends(uid1, uid2);
        for (int i = 0; i < ids.size(); i++) {
            System.out.println(httpRequest.getUserInfoByUid(Integer.parseInt(ids.get(i))));
        }

        StatisticAnalyzer analyzer = new StatisticAnalyzer();
        analyzer.printAll(ids, uid1, uid2);

        */

        DatabaseManager databaseManager = new DatabaseManager();
        databaseManager.printAll();


    }

}
