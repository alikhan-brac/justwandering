package pages;

import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    private final WebElement SAMPLE_APP_LINK = getElementByXpath("//*[contains(text(),'Sample')]");

    public void clickSampleApp() {
        SAMPLE_APP_LINK.click();
    }

    public WebElement pageLoaded() {
        return elementIsDisplayed(SAMPLE_APP_LINK);
    }
}
