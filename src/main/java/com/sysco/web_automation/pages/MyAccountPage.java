package com.sysco.web_automation.pages;

import org.openqa.selenium.By;

public class MyAccountPage extends BasePage {

    private By btnLogin = By.id("send2");
    private By txtEmail = By.id("email");
    private By txtPwd = By.id("pass");
    private By divPwdValidationMsg = By.id("advice-required-entry-pass");
    private By divUserNameValidationMsg = By.id("advice-required-entry-email");
    private By spnInvalidCredentials = By.xpath("//span[contains(text(),'Invalid login or password.')]");

    private By divWelcomeMsg = By.xpath("//div[@class='dashboard']//div[@class='welcome-msg']");

    public boolean isLoginBtnAvailable(){
        return isDisplayed(btnLogin,5L);
    }

    public void submitEmail(String email){
        syscoLabUI.clear(txtEmail);
        syscoLabUI.sendKeys(txtEmail,email);
    }

    public void submitPwd(String pwd){
        syscoLabUI.clear(txtPwd);
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

    public String getPasswordFieldRequired() {
        return syscoLabUI.getText(divPwdValidationMsg);
    }

    public String getUserNameRequired() {
        return syscoLabUI.getText(divUserNameValidationMsg);
    }

    public String getInvalidUserNameOrPwValidationMsg(){
        return syscoLabUI.getText(spnInvalidCredentials);
    }
}
