package utilities;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;

public class BrowserUtil {
    private static final String BASE_URL = "http://uitestingplayground.com/";

    private static Browser getBrowser() {
        return AqualityServices.getBrowser();
    }

    public static void browserStart() {
        getBrowser().getDriver().manage().window().maximize();
        getBrowser().goTo(BASE_URL);
    }

    public static void browserQuit() {
        if (AqualityServices.isBrowserStarted()) {
            AqualityServices.getBrowser().quit();
        }
    }
}
