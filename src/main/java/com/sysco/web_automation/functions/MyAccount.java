package com.sysco.web_automation.functions;

import com.sysco.web_automation.data.UserData;
import com.sysco.web_automation.pages.MyAccountPage;

public class MyAccount {

    private static MyAccountPage myAccountPage = new MyAccountPage();

    public static boolean isLoginBtnAvailable(){
        return myAccountPage.isLoginBtnAvailable();
    }

    public static void submitUserCredentials(UserData userObj){
        myAccountPage.submitEmail(userObj.getUserName());
        myAccountPage.submitPwd(userObj.getPassword());
        myAccountPage.clickLogin();
    }

    public static boolean isWelcomeMsgAvailable(){
        return myAccountPage.isWelcomeMsgAvailable();
    }

    public static boolean verifyLoggedInUser(UserData userObj){
        String fullName = userObj.getFirstName()+" "+userObj.getLastName();
        return myAccountPage.getWelcomeMsg().contains(fullName);
    }
}
