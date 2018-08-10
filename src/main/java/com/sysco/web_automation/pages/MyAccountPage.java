package com.sysco.web_automation.pages;

import org.openqa.selenium.By;

public class MyAccountPage extends BasePage {

    private By btnLogin = By.id("send2");
    private By txtEmail = By.id("email");
    private By txtPwd = By.id("pass");

    private By divWelcomeMsg = By.xpath("//div[@class='dashboard']//div[@class='welcome-msg']");

    public boolean isLoginBtnAvailable(){
        return isDisplayed(btnLogin,5L);
    }

    public void submitEmail(String email){
        syscoLabUI.sendKeys(txtEmail,email);
    }

    public void submitPwd(String pwd){
        syscoLabUI.sendKeys(txtPwd,pwd);
    }

    public void clickLogin(){
        syscoLabUI.click(btnLogin);
    }

    public boolean isWelcomeMsgAvailable(){
       return syscoLabUI.getText(divWelcomeMsg).contains("HELLO");
    }

    public String getWelcomeMsg(){
        return syscoLabUI.getText(divWelcomeMsg);
    }
}
