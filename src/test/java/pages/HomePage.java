package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HomePage extends Form {
    private ILabel SAMPLE_APP_LINK = getElementFactory()
            .getLabel(By.xpath("//*[@id=\"overview\"]/div/div[4]/div[2]/h3/a"), "Sample App");

    public HomePage() {
        super(By.xpath("//*[@id=\"overview\"]/div/div[4]/div[2]/h3/a"), "Sample App -identifier for home page");
    }

    public void clickSampleApp() {
        SAMPLE_APP_LINK.click();
    }
}
