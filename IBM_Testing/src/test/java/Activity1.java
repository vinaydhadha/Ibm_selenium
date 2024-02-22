import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.openqa.selenium.logging.LogType.DRIVER;

public class Activity1 {
    WebDriver driver;

    @BeforeClass
    public void berforeMethod(){
        WebDriverManager.chromedriver().setup();;
        driver = new ChromeDriver();

        driver.get("https://v1.training-support.net");
    }
    @Test
    public  void testCase(){
        String title = driver.getTitle();

        System.out.println("Page title is : " + title);

        Assert.assertEquals("Training Support", title);
        driver.findElement(By.id("about-link")).click();
        System.out.println("new pGE TITLE IS:"+driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "About Training Support");
    }

    @AfterClass
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}
