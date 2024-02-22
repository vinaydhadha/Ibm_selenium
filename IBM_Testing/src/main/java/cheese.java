import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class cheese {
    public static void main(String[] args){


    WebDriver driver = new EdgeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.google.in/");
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("Dora", Keys.RETURN);
        wait.until(ExpectedConditions.titleContains("Dora"));
        String pageTitle = driver.getTitle();
        System.out.println("page title is: " + pageTitle);

        // method to take screenshoots

        String fileName = System.currentTimeMillis() +" Test";
        File screenshot = ((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
        File outputFile = new File ("LoggerScreenScreenshots/"+ fileName+".png");
        System.out.println(outputFile.getAbsolutePath());

        try{
            FileUtils.copyFile(screenshot, outputFile);
        }catch(IOException e){
            e.printStackTrace();
        }
          driver.quit();
    }}
