package basic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	public static void takeScreenshot(WebDriver driver, String fileName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Path destination = Paths.get("./outcomefiles-ScreenShots", fileName + ".png");
        try {
            Files.copy(screenshot.toPath(), destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
