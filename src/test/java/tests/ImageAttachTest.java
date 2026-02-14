package tests;

import io.qameta.allure.Attachment;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.BrowserUtil;
import utilities.FileUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageAttachTest extends BaseTest{
    private final String screenshotFileName = "src/main/resources/screenshot.jpeg";

    @Attachment(value = "Screenshot", type = "image/jpeg")
    public byte[] attachScreenshot(File screenshot) {
        try {
            return Files.readAllBytes(screenshot.toPath()); // Attach screenshot as byte array
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0]; // Return empty byte array on error
        }
    }

    @Test(description = "checking screenshot attachment with allure")
    public void testScreenshot() {
        File screenshotFile = FileUtil.takeScreenshot(BrowserUtil.getBrowser().getDriver(), screenshotFileName);
        if (screenshotFile != null) {
            attachScreenshot(screenshotFile); // Attach the screenshot
        }
    }

    @AfterMethod(alwaysRun = true)
    public void cleanup() {
        deleteScreenshot(screenshotFileName);
    }

    private void deleteScreenshot(String fileName) {
        try {
            Files.deleteIfExists(Path.of(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
