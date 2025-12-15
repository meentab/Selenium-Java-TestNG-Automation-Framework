package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenshotUtil {
    public static void takeScreenshot(WebDriver driver, String targetPath) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.createDirectories(Path.of(targetPath).getParent());
            Files.copy(src.toPath(), Path.of(targetPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
