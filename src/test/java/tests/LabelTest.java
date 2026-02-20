package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.NORMAL;

public class LabelTest {

    @Severity(NORMAL)
    @Owner("John Doe")
    @Test(description = "Test with Allure 3 label annotation")
    public void labelForAllure3Test() {
        Allure.label("Responsible", "Egor Sokolov");
        stepChecking();
    }

    @Step("Checking step with Allure 3")
    private void stepChecking(){
        int n = 1;
        Assert.assertEquals(1, n, "This test is intentionally passing for demonstration.");
    }
}
