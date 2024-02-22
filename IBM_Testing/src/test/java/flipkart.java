import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;

public class flipkart{
    public static void main(String[] args){

       // ChromeOptions chromeOptions = new ChromeOptions();
       // chromeOptions.setHeadless(true);
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.flipkart.com");
        WebElement searchbox = driver.findElement(By.xpath("//input[@class='Pke_EE']"));
        driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("iphone 15");
        //driver.findElement(By.xpath("//button[@class='2iLD_']")).click();
        searchbox.sendKeys(Keys.RETURN);

        List<WebElement> list_title = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
        System.out.println(list_title.get(2).getText());

        List<WebElement> list_price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
        System.out.println(list_price.get(2).getText());


        driver.close();

    }
}