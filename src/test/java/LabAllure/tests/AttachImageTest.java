package LabAllure.tests;

import LabAllure.util.ScreenshotUtil;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.testng.SkipException;
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

    @Test(description = "An intentional ignored test")
    public void testIgnored() {
        throw new SkipException("This test is intentionally ignored for demonstration.");
    }

    @Test(description = "An intentional erroneous test")
    public void testFailing() {
        throw new RuntimeException("This test is intentionally having run time exception for demonstration.");
    }

    @Attachment(value = "Debug text", type = "text/plain")
    @Step("Attaching text to Allure report")
    private String attachText() {
        return "OS: " + System.getProperty("os.name") +
                "\nVersion: " + System.getProperty("os.version") +
                "\nArchitecture: " + System.getProperty("os.arch");
    }

    @AfterTest(description = "Closing Webdriver", alwaysRun = true)
    public void tearDown() {
        AqualityServices.getBrowser().quit();
    }
}
