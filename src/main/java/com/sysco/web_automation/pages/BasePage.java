package com.sysco.web_automation.pages;

import com.sysco.web_automation.common.Constants;
import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class BasePage {

        protected static SyscoLabUI syscoLabUI;
        protected static RemoteWebDriver webDriver;

        public BasePage(){
            syscoLabUI = new SyscoLabUI();
            syscoLabUI.driver = webDriver;
        }

        public static void setWebDriver(RemoteWebDriver webDriver) {
            BasePage.webDriver = webDriver;
        }

        protected boolean isDisplayed(By by, Long timeOut){
            webDriver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
            WebElement element = webDriver.findElement(by);
            return syscoLabUI.isDisplayed(element);
        }
}
