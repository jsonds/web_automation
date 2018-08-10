package com.sysco.web_automation.pages;

import org.openqa.selenium.By;

public class UserVerificationPage extends BasePage {

    private By ddDay = By.id("age_select_day");
    private By ddMonth = By.id("age_select_month");
    private By ddYear = By.id("age_select_year");
    private By btnEnter = By.id("age_confirm_btn");
    private By divIllegalUserErrorMsg = By.id("age_missing_message");

    public void selectDay(String day){
        syscoLabUI.selectFromDropDown(ddDay,day);
    }
    public void selectMonth(String month){
        syscoLabUI.selectFromDropDown(ddMonth,month);
    }
    public void selectYear(String year){
        syscoLabUI.selectFromDropDown(ddYear,year);
    }
    public void clickEnterBtn(){
        syscoLabUI.click(btnEnter);
    }

    public String getIllegalUserErrorMessage(){
        return syscoLabUI.findElement(divIllegalUserErrorMsg ).getText();
    }
    public void waitUntillPageLoaded(){
        syscoLabUI.waitTillElementLoaded(btnEnter);
    }
}
