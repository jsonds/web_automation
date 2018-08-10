package com.sysco.web_automation.functions;

import com.sysco.web_automation.data.UserData;
import com.sysco.web_automation.pages.UserVerificationPage;

public class UserVerification {
    private static UserVerificationPage userVerificationPage = new UserVerificationPage();

    public static void verifyPageLoaded(){
        userVerificationPage .waitUntillPageLoaded();
    }
    public static void enterBirthDate(UserData userData){

        userVerificationPage .selectDay(userData.getBirthDay());
        userVerificationPage .selectMonth(userData.getBirthMonth());
        userVerificationPage .selectYear(userData.getBirthYear());
        userVerificationPage .clickEnterBtn();
    }

    public static String getErrorMessage(){
        return userVerificationPage .getErrorMessage();
    }
}
