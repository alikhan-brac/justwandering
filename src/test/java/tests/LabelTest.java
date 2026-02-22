package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.NORMAL;

public class LabelTest {
    private final String customizedLabel = System.getProperty("test.customizedLabel", "Responsible");
    private final String customizedLabelValue = System.getProperty("test.customizedLabelValue", "Jonthan-default");

    @Severity(NORMAL)
    @Owner("Tom Smith")
    @Test(description = "Test with Allure 3 label annotation")
    public void labelForAllure3Test() {
//        String responsible = System.getProperty("test.responsible", "Jonthan-default");
//        Allure.label("Responsible", responsible);

        Allure.label(customizedLabel, customizedLabelValue);
        stepChecking();
    }

    @Step("Checking step with Allure 3")
    private void stepChecking(){
        int n = 1;
        Assert.assertEquals(1, n, "This test is intentionally passing for demonstration.");
    }
}
