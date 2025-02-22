package pages;

import org.openqa.selenium.WebElement;

public class SampleAppPage extends BasePage{
    private final WebElement USER_NAME_INPUT = getElementByXpath("//input[contains(@placeholder,'User Name')]");
    private final WebElement PASSWORD_INPUT = getElementByXpath("//input[contains(@name,'Password')]");
    private final WebElement LOGIN_BUTTON = getElementByXpath("//*[@id=\"login\"]");
    private final WebElement WELCOME_LABEL = getElementByXpath("//*[@id=\"loginstatus\"]");

    public WebElement pageLoaded() {
        return elementIsDisplayed(USER_NAME_INPUT);
    }

    public void inputUserName(String userName) {
        USER_NAME_INPUT.sendKeys(userName);
    }

    public void inputPassword(String password) {
        PASSWORD_INPUT.sendKeys(password);
    }

    public void clickLogin() {
        LOGIN_BUTTON.click();
    }

    public String getWelcomeText() {
        return WELCOME_LABEL.getText();
    }
}
