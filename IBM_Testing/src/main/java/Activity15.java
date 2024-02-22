import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity15 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new ChromeDriver();
        // Create the Wait object

        // Open the page
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        String pageTitle = driver.getTitle();
        System.out.println("Home page title: " + driver.getTitle());
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/div[1]/input"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/div[2]/input"));

           usernameField.sendKeys("admin");
           passwordField.sendKeys("password");

        // Find and click the submit button
        driver.findElement(By.xpath("//*[@id=\"dynamic-attributes-form\"]/div/button")).click();

        // Print the login message
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + message);


        //driver.close();
    }

}
