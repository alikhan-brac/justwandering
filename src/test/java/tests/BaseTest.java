package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.BrowserUtil;

public class BaseTest {

    @BeforeMethod
    protected void beforeMethod() {
        BrowserUtil.browserStart();
    }

    @AfterMethod
    protected void afterMethod() {
        BrowserUtil.browserQuit();
    }
}
