import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {
    public static void main(String[] args){
    WebDriver driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/drag-drop");
    String pageTitle = driver.getTitle();
        System.out.println("page title is: " + pageTitle);

        WebElement togglebButton = driver.findElement(By.cssSelector("#toggleCheckbox"));
        togglebButton.click();
        //wait till the checkbox disappers
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("checkbox")));
        // click the button again
        togglebButton.click();
        // wait till the checkbox appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        // check the checkbox
        WebElement checkbox = driver.findElement(By.id("checkbox"));
        checkbox.click();
        driver.quit();
}
}
