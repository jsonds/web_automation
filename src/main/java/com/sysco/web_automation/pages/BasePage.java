package com.sysco.web_automation.pages;

import com.syscolab.qe.core.common.LoggerUtil;
import com.syscolab.qe.core.ui.SyscoLabUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

import static com.sysco.web_automation.common.Constants.DEFAULT_TIMEOUT;

public abstract class BasePage {



        protected static SyscoLabUI syscoLabUI;
        protected static RemoteWebDriver webDriver;

        public BasePage(){
            syscoLabUI = new SyscoLabUI();
            syscoLabUI.driver = webDriver;
        }

        protected boolean isDisplayed(By by, Long timeOut){
            webDriver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
            try{
                WebElement element = webDriver.findElement(by);
                webDriver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
                return syscoLabUI.isDisplayed(element);
            } catch (Exception e){
                LoggerUtil.logERROR("Element located by: " + by +  " not displayed", e);
                webDriver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
                return false;
            }

        }

        public static void setWebDriver(RemoteWebDriver webDriver) {
            BasePage.webDriver = webDriver;
        }

        public void sleep(long seconds){

            try {
                Thread.sleep(seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


}
