package com.sysco.web_automation.utils;


import com.sysco.web_automation.pages.BasePage;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import com.syscolab.qe.core.reporting.SyscoLabQCenter;
import com.syscolab.qe.core.reporting.SyscoLabReporting;
import com.sysco.web_automation.common.Constants;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Listeners(SyscoLabListener.class)
public class TestBase {
    private SyscoLabListener testListeners;
    private SyscoLabQCenter syscoLabQCenter;
    private SyscoLabWUI syscoLabWUI;

    @BeforeClass
    public void init() {
        testListeners = new SyscoLabListener();
        syscoLabQCenter = new SyscoLabQCenter();
        DriverSetUpUtil.setToRunLocally();
        syscoLabWUI = new SyscoLabWUI(null);
        try {
            String URL = URLEncoder.encode(Constants.APP_URL, "UTF-8");
            syscoLabWUI.navigateTo(Constants.APP_URL);
            syscoLabWUI.getDriver().manage().window().maximize();
            BasePage.setWebDriver(syscoLabWUI.getDriver());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Test Running " + this.getClass().toString());
    }

    @AfterClass(alwaysRun = true)
    public void cleanUp(ITestContext iTestContext) {
        syscoLabWUI.quit();

        try {
            syscoLabQCenter.setProjectName(Constants.TEST_PROJECT);
            syscoLabQCenter.setEnvironment(Constants.TEST_ENV);

            syscoLabQCenter.setRelease(Constants.TEST_RELEASE);
            syscoLabQCenter.setModule(iTestContext.getAttribute("feature").toString());
            syscoLabQCenter.setFeature(iTestContext.getAttribute("feature").toString());
            syscoLabQCenter.setClassName(iTestContext.getClass().getName());

            if (Constants.UPDATE_DASHBOARD)
                SyscoLabReporting.generateJsonFile(SyscoLabListener.getResults(), syscoLabQCenter);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
