package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class SampleAppPage extends Form {
    private final ITextBox USER_NAME_INPUT = getElementFactory()
            .getTextBox((By.xpath("//input[contains(@placeholder,'User Name')]")), "User Name");
    private final ITextBox PASSWORD_INPUT = getElementFactory()
            .getTextBox((By.xpath("//input[contains(@name,'Password')]")), "Password");
    private final IButton LOGIN_BUTTON = getElementFactory()
            .getButton((By.xpath("//*[@id=\"login\"]")), "Login");
    private final ILabel WELCOME_LABEL = getElementFactory()
            .getLabel((By.xpath("//*[@id=\"loginstatus\"]")), "Welcome text");

    public SampleAppPage() {
        super(By.xpath("/html/body/section/div/h3"), "Sample App Page Header");
    }

    public void inputUserName(String userName) {
        USER_NAME_INPUT.clearAndType(userName);
    }

    public void inputPassword(String password) {
        PASSWORD_INPUT.clearAndType(password);
    }

    public void clickLogin() {
        LOGIN_BUTTON.click();
    }

    public String getWelcomeText() {
        return WELCOME_LABEL.getText();
    }
}
