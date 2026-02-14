package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtil {

    public static File takeScreenshot(WebDriver driver, String fileName) {
        Path path = Path.of(fileName);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(screenshot.toPath(), path);
            System.out.println("Image file created: " + path.toAbsolutePath());
            return path.toFile(); // Return the File object
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Return null if there's an error
        }
    }
}
