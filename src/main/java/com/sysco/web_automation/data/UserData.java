package com.sysco.web_automation.data;

public class UserData {

    private String birthDay;

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

    private String birthMonth;
    private String birthYear;

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
}
