import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class iciciBank {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.icicibank.com");
       WebElement cards = driver.findElement(By.linkText("Cards"));

        driver.findElements(By.linkText("Prepaid Cards"));

        List<WebElement> priceList = driver.findElements(By.linkText("Prepaid"));
        int xpathCount = priceList.size();
        System.out.println("Total xpath: " + xpathCount);

        driver.quit();
    }
}
