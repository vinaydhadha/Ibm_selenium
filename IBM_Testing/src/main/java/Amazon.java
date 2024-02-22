import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class Amazon {
    public static void main(String [] arg){
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.amazon.in/");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone 15");

        driver.findElement(By.id("nav-search-submit-button")).click();

        List<WebElement> priceList = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

        WebElement thirdPrice = priceList.get(2);
        System.out.println("Third Price: " + thirdPrice.getText());

        //driver.quit();
    }
}
