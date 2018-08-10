package com.sysco.web_automation.tests;

import com.sysco.web_automation.data.UserData;
import com.sysco.web_automation.functions.Home;
import com.sysco.web_automation.functions.MyAccount;
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
        String ILLEGAL_USER_ERROR_MSG = "Sorry, your age or location does not permit you to enter at this time.";

        UserVerification.verifyPageLoaded();
        UserData illegalUser = new UserData(2);
        UserVerification.enterBirthDate(illegalUser);
        String errorMsg = UserVerification.getIllegalUserErrorMessage();

        softAssert.assertEquals(errorMsg, ILLEGAL_USER_ERROR_MSG);
        softAssert.assertAll();

    }

    @Test(description = "Verify legal user is navigated to home page",  dependsOnMethods = "testIllegalUser")
    public void testLegalUser(){

        softAssert = new SoftAssert();

        UserVerification.verifyPageLoaded();
        UserData validUser = new UserData(1);
        UserVerification.enterBirthDate(validUser);

        softAssert.assertTrue(Home.verifyPageLoaded());
        softAssert.assertAll();
    }

    @Test(description = "Verify Navigating to My Account" , dependsOnMethods = "testLegalUser")
    public void testNavigateToMyAcc(){

        softAssert = new SoftAssert();

        Home.navigateToMyAcc();

        softAssert.assertTrue(MyAccount.isLoginBtnAvailable());
        softAssert.assertAll();
    }

    public void testValidateLoginCorrectCredentials(){

    }

    public void testValidateLoginIncorrectCredentials(){

    }

    @Test(description = "Verify Login to My Account" , dependsOnMethods = "testNavigateToMyAcc")
    public void testLoginToAcc(){

        softAssert = new SoftAssert();

        UserData validCredential = new UserData("validUser");
        MyAccount.submitUserCredentials(validCredential);

        softAssert.assertTrue(MyAccount.isWelcomeMsgAvailable());
        softAssert.assertAll();
    }

    @Test(description = "Verify Logedin Users Name", dependsOnMethods = "testLoginToAcc")
    public void testVerifyLogedInUserName(){

        softAssert = new SoftAssert();

        UserData validCredential = new UserData("validUser");

        softAssert.assertTrue(MyAccount.verifyLoggedInUser(validCredential));
        softAssert.assertAll();

    }

}
