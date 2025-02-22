package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SampleAppPage;

import static constants.LoginConstants.*;

public class SampleAppInvalidCredentialTest extends BaseTest {

    @Test(description = "Sample app - invalid credential test")
    public void sampleAppInvalidCredentialTest() {
        testCaseId = "5";
        HomePage homePage = new HomePage();
        Assert.assertNotNull(homePage.pageLoaded(), "HomePage did not load correctly");
        homePage.clickSampleApp();

        SampleAppPage sampleAppPage = new SampleAppPage();
        Assert.assertNotNull(sampleAppPage.pageLoaded(), "SampleApp page did not load correctly");

        sampleAppPage.inputUserName(USER_ID);
        sampleAppPage.inputPassword(INVALID_PASSWORD);
        sampleAppPage.clickLogin();

        Assert.assertEquals(sampleAppPage.getWelcomeText(), EXPECTED_TEXT_FOR_INVALID_CREDENTIAL,
                "Welcome message mismatch");
    }
}
