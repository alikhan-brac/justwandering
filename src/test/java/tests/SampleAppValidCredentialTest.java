package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SampleAppPage;
import util.ScreenshotUtil;
import util.SingletonDriver;

import static constants.LoginConstants.*;

public class SampleAppValidCredentialTest extends BaseTest {

    @Test(description = "Sample app - valid credential test")
    public void sampleAppValidCredentialTest() {
        testCaseId = "4";
        HomePage homePage = new HomePage();
        Assert.assertNotNull(homePage.pageLoaded(), "HomePage did not load correctly");
        homePage.clickSampleApp();

        SampleAppPage sampleAppPage = new SampleAppPage();
        Assert.assertNotNull(sampleAppPage.pageLoaded(), "SampleApp page did not load correctly");

        sampleAppPage.inputUserName(USER_ID);
        sampleAppPage.inputPassword(PASSWORD);
        sampleAppPage.clickLogin();

        testScreenshot();

        Assert.assertEquals(sampleAppPage.getWelcomeText(), EXPECTED_TEXT, "Welcome message mismatch");
    }

    private void testScreenshot() {
        ScreenshotUtil.captureScreenshot(SingletonDriver.getInstance().getDriver(), SCREENSHOT_FILE_NAME);
    }
}
