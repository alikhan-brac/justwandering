package tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import util.SingletonDriver;
import util.TestRailManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static constants.LoginConstants.BASE_URL;
import static constants.LoginConstants.SCREENSHOT_FILE_NAME;

public abstract class BaseTest {
    protected String testCaseId;

    @BeforeTest
    protected void beforeMethod() {
        SingletonDriver.getInstance().goToUrl(BASE_URL);
    }

    //TestNG's @AfterTest does not allow the use of ITestResult as a parameter.
    // The ITestResult object can only be injected into @AfterMethod or test methods.
    @AfterMethod
    protected void tearDownAndLogResult(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.SUCCESS) {
                TestRailManager.addResultsForTestCase(
                        testCaseId,
                        TestRailManager.TEST_CASE_PASS_STATUS, "Test passed");
            } else if (result.getStatus() == ITestResult.FAILURE) {
                TestRailManager.addResultsForTestCase(
                        testCaseId,
                        TestRailManager.TEST_CASE_FAIL_STATUS, "Test failed");
            }
        } catch (Exception e) {
            System.err.println("Failed to log results to TestRail: " + e.getMessage());
            e.printStackTrace();
        } finally {
            SingletonDriver.getInstance().quitDriver();
            deleteScreenshot();
        }
    }

    private void deleteScreenshot() {
        try {
            Files.deleteIfExists(Path.of(SCREENSHOT_FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
