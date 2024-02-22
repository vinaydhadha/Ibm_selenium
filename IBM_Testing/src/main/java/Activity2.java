import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Activity2 {
    public static void main(String[] args) {

        WebDriverManager.edgedriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new EdgeDriver();

        // Open the browser
        driver.get("https://v1.training-support.net/selenium/login-form");

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password");

        WebElement logIn = driver.findElement(By.xpath("button"));
        logIn.click();
 //driver.quit();
    }
}