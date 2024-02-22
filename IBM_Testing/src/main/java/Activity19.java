import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Alert;

public class Activity19 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");


        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);


        WebElement confirmButton = driver.findElement(By.id("confirm"));
        confirmButton.click();


        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);

        alert.accept();

        confirmButton.click();
        alert = driver.switchTo().alert();

        alert.dismiss();

        driver.quit();

    }
}