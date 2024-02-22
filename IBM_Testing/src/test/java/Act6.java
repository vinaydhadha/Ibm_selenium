import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Act6 {
    WebDriver driver;

    @BeforeClass()
    public void berforeMethod() {
        WebDriverManager.chromedriver().setup();
        ;
        driver = new ChromeDriver();

        driver.get("https://v1.training-support.net/selenium/login-form");
    }



    @Test
    @Parameters({"username", "password"})
    public void LoginTestCase(String Username, String password) {
        //Find username and pasword fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        //Enter values
        usernameField.sendKeys(Username);
        passwordField.sendKeys(password);

        //Click Log in
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        //Assert Message
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        //System.out.println(loginMessage);
        Assert.assertEquals(loginMessage, "Welcome Back, admin");
    }


        @AfterTest()
        public void afterMethod () {
            //Close the browser
            driver.close();
        }
    }

