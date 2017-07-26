package pojo;

import http.HttpRequest;
import org.json.JSONException;

import java.io.IOException;

public class User {

    private int uid;
    private String fullName;
    private int sex;
    private String birthday;
    private String city;
    private String universityName;
    private String faculty;
    private int graduation;
    private String educationStatus;
    private String status;



    public User() {

    }

    public User(int uid, String fullName, int sex, String birthday, String city,
                String universityName, String faculty, int graduation,
                String educationStatus, String status) {
        this.uid = uid;
        this.fullName = fullName;
        this.sex = sex;
        this.birthday = birthday;
        this.city = city;
        this.universityName = universityName;
        this.faculty = faculty;
        this.graduation = graduation;
        this.educationStatus = educationStatus;
        this.status = status;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getGraduation() {
        return graduation;
    }

    public void setGraduation(int graduation) {
        this.graduation = graduation;
    }

    public String getEducationStatus() {
        return educationStatus;
    }

    public void setEducationStatus(String educationStatus) {
        this.educationStatus = educationStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {

        return "[+]User " + fullName + "\n" +
                "=============================================\n" +
                "\n------------Личная информация--------------\n" +
                " Cтатус = " + status + " \n" +
                " " + "\n" +
                " uid = " + uid + "\n" +
                " Пол = " + getTitleSex(sex) + "\n" +
                " День рождения = " + birthday  + '\n' +
                " Город = " + city  + '\n' +
                "------------Высшее Образование--------------\n" +
                " Университет = " + universityName  + '\n' +
                " Факультет = " + faculty  + '\n' +
                " Дата окончания = " + graduation  + "\n" +
                " Статус студента = " + educationStatus  + '\n' +
                "=============================================\n";

    }

    private String getTitleSex(int sex) {
        String sexTitle = null;

        if(sex == 1) {
            sexTitle = "Ж";
        } else if(sex == 2) {
            sexTitle = "M";
        }

        return sexTitle;
    }

}
