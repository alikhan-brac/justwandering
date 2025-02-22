package util;

import constants.LoginConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SingletonDriver {
    private static volatile SingletonDriver instance;
    private WebDriver driver;

    private SingletonDriver() {
        driver = createDriver();
    }

    public static SingletonDriver getInstance() {
        if (instance == null) {
            synchronized (SingletonDriver.class) {
                if (instance == null) {
                    instance = new SingletonDriver();
                }
            }
        }
        return instance;
    }

    private WebDriver createDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--ignore-certificate-errors");  // Disables SSL errors
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");
        WebDriverManager.chromedriver().setup(); // Ensure the driver is set up
        WebDriver driver = WebDriverManager.chromedriver().capabilities(chromeOptions).avoidShutdownHook().create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(LoginConstants.MAX_WAIT));
        return driver;
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset the driver to allow for a new instance to be created later
            instance = null; // Reset the instance to allow for a new instance to be created later
        }
    }

    // Getter for the WebDriver instance
    public WebDriver getDriver() {
        return driver;
    }
}
