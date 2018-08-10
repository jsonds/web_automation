package com.sysco.web_automation.tests;

import com.sysco.web_automation.data.UserData;
import com.sysco.web_automation.functions.Home;
import com.sysco.web_automation.functions.UserVerification;
import com.sysco.web_automation.utils.TestBase;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(SyscoLabListener.class)
public class BundaberGumTest extends TestBase {


    private SoftAssert softAssert;
    @BeforeClass
    public void initClass(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Bundabergrum - Checkout");
    }

    @Test(description = "Verify illegal user is stopped accesing the home page")
    public void testIllegalUser(){

        softAssert = new SoftAssert();
        UserVerification.verifyPageLoaded();
        UserData illegalUser = new UserData(2);
        UserVerification.enterBirthDate(illegalUser);
        String errorMsg = UserVerification.getIllegalUserErrorMessage();
        softAssert.assertEquals(errorMsg, "Sorry, your age or location does not permit you to enter at this time.");
        softAssert.assertAll();

    }

    @Test(description = "Verify legal user is navigated to home page")
    public void testLegalUser(){

        softAssert = new SoftAssert();
        UserVerification.verifyPageLoaded();
        UserData validUser = new UserData(1);
        UserVerification.enterBirthDate(validUser);
        softAssert.assertTrue(Home.verifyPageLoaded(), "Verify legal age user is navigated to home page.");
        softAssert.assertAll();
    }

    @Test(description = "Verify Login Button exists")
    public void testLoginButtonAvailability(){
        
    }

}
