import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/ajax");
        String pageTitle = driver.getTitle();
        System.out.println("page title is: " + pageTitle);
        WebElement changeContentButton = driver.findElement(By.id("ajax-content"));
        changeContentButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"),"HELLO!"));
        String helloMessage = driver.findElement(By.id("ajax-content")).getText();
        System.out.println("Message after clicking 'Change content': " + helloMessage);

        // Wait for the text to change to contain "I'm late!". Print the new message on the page
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "I'm late!"));
        String lateMessage = driver.findElement(By.id("ajax-content")).getText();
        System.out.println("Message after content change: " + lateMessage);

        // Close the browser
        driver.quit();
}}

