import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Activity6 {
    public static void main(String [] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/input-events");
        String pageTitle = driver.getTitle();
        Actions builder = new Actions(driver);
        System.out.println("This title od the page :"+ pageTitle);
        //perform left click
        builder.click().pause(1000).build().perform();
        //print the front side text
        String frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);
        // Perform left click
        builder.doubleClick().pause(1000).build().perform();
        // Print the front side text
        frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);

        // Perform left click
        builder.contextClick().pause(1000).build().perform();
        // Print the front side text
        frontText = driver.findElement(By.className("active")).getText();
        System.out.println(frontText);

        // Close the browser
        driver.close();
    }
}
