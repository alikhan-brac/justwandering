package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.SingletonDriver;

public abstract class BasePage {

    private WebDriver getDriver() {
        return SingletonDriver.getInstance().getDriver();
    }

    protected WebElement getElementByXpath(String xpath) {
        return getDriver().findElement(By.xpath(xpath));
    }

    protected WebElement elementIsDisplayed(WebElement element) {
        if (element == null || !element.isDisplayed()) {
            throw new IllegalStateException("Element is not displayed!");
        }
        return element;
    }
}
