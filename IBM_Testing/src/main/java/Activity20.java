import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity20 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");


        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);


        driver.findElement(By.id("prompt")).click();

        // Switch focus to the alert
        Alert promtAlert = driver.switchTo().alert();

        // Print the text in the alert
        String alertText = promtAlert.getText();
        System.out.println("Text in alert: " + alertText);
        // Type into the alert
        promtAlert.sendKeys("Awesome!");

        // Close the alert by clicking OK
        promtAlert.accept();

        // Can also close the alert by clicking Cancel
        // promtAlert.dismiss();

        // Close the browser
        driver.quit();

    }
}
