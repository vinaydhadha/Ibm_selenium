import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class demo1 {
    public static void main(String[] args){
         WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //lauch website
        driver.navigate().to("http://www.calculator.net/");

        //maximize the brower
        driver.manage().window().maximize();

        // click on math calculators
        driver.findElement(By.xpath(".//*[@id = 'menu']/div[3]/a")).click();
        // click on the percent calculators
        driver.findElement(By.xpath(".//*[@id = 'menu']/div[4]/div[3]/a")).click();

        driver.findElement(By.id("cpar1")).sendKeys("10");
        driver.findElement(By.id("cpar2")).sendKeys("50");
        //get the result text based on its xpath
        String result = driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/font/b")).getText();
        System.out.println("The Resukt is "+ result);
        driver.close();
    }
}
