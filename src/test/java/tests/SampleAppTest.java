package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SampleAppPage;

import java.util.UUID;

public class SampleAppTest extends BaseTest {
    private final HomePage homePage = new HomePage();
    private final SampleAppPage sampleAppPage = new SampleAppPage();
    private final String userId = UUID.randomUUID().toString();
    private final String expectedText = String.format("Welcome, %s!", userId);
    private final String password = "pwd";


    @Test()
    public void sampleAppTest() {
        homePage.state().isDisplayed();
        homePage.clickSampleApp();
        sampleAppPage.state().isDisplayed();
        sampleAppPage.inputUserName(userId);
        sampleAppPage.inputPassword(password);
        sampleAppPage.clickLogin();
        Assert.assertEquals(sampleAppPage.getWelcomeText(), expectedText, "Welcome message mismatch");
    }
}
