package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {
    //method to take screenshot when TC fails
    public static void captureScreenshot(WebDriver driver,String screenshotName)
    {
        Path des = Paths.get("./Screenshots", STR."\{screenshotName}.png");
        try {
            Files.createDirectories(des.getParent());
            FileOutputStream out = new FileOutputStream(des.toString());
            out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (IOException e) {
            System.out.println(STR."Error while capturing screenshon \{e.getMessage()}");

        }
    }
}
