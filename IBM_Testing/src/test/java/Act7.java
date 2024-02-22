import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Act7 {
    WebDriver driver;

    @BeforeClass()
    public void berforeMethod() {
        WebDriverManager.chromedriver().setup();
        WebDriverWait wait;

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://v1.training-support.net/selenium/login-form");
    }



        @DataProvider(name = "Authentication")
        public static Object[][] credentials() {
            return new Object[][] { { "admin", "password" }};
        }

        @Test(dataProvider = "Authentication")
        public void loginTestCase(String username, String password) {

            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys(username);
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys(password);

            driver.findElement(By.cssSelector("button[type='submit']")).click();

            String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
            Assert.assertEquals(loginMessage, "Welcome Back, admin");
        }
        @AfterTest()
        public void afterMethod () {
            //Close the browser
            driver.close();
        }
    }

