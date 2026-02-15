package LabAllure.tests;

import LabAllure.util.ScreenshotUtil;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.testng.annotations.*;

import org.testng.annotations.Test;

public class AttachImageTest {

    @Test(description = "Screenshot capture and other attachment in allure test")
    public void testWithScreenshot() {
        Browser browser = AqualityServices.getBrowser();
        browser.goTo("http://uitestingplayground.com/sampleapp");
        ScreenshotUtil.captureScreenshot(browser.getDriver());

        attachText();
    }

    @Attachment(value = "Debug text", type = "text/plain")
    @Step("Attaching text to Allure report")
    private String attachText() {
        return "Hello Allure";
    }

    @AfterTest(description = "Closing Webdriver",alwaysRun = true)
    public void tearDown() {
        AqualityServices.getBrowser().quit();
    }
}
