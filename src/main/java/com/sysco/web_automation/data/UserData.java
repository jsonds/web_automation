package com.sysco.web_automation.data;

public class UserData {

    private String birthDay;
    private String birthMonth;
    private String birthYear;

    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }


    public UserData(int userType){
        switch (userType){
            case 1:
                birthDay = "1";
                birthMonth ="January";
                birthYear =  "1980";
                break;
            case 2:
                birthDay = "1";
                birthMonth ="January";
                birthYear =  "2003";
                break;
        }
    }

    public UserData(String userType){
        switch (userType){
            case "validUser":
                userName = "williamjacob802@gmail.com";
                password = "12345678";
                break;
        }

    }
}
