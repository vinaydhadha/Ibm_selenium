import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity5 {
    public static void main( String [] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/input-events");
        String pageTitle = driver.getTitle();
        System.out.println("The title of the page is: "+ pageTitle);

        // Perform a left click and print the value of the side in the front
        WebElement frontSide = driver.findElement(By.id("left-click"));
        String frontSideValue = frontSide.getAttribute("value");
        System.out.println("The value of the side in the front after a left click is: " + frontSideValue);

        // Perform a double click to show a random side and print the number
        WebElement cube = driver.findElement(By.id("double-click"));
        Actions action = new Actions(driver);
        action.doubleClick(cube).perform();
        WebElement randomSide = driver.findElement(By.className("active"));// active is the class name we have to find in website
        String randomSideNumber = randomSide.getText();
        System.out.println("The number of the random side after a double click is: " + randomSideNumber);
        // Perform a right click and print the value shown on the front of the cube
        WebElement backSide = driver.findElement(By.id("right-click"));
        action.contextClick(backSide).perform();
        WebElement frontSideAgain = driver.findElement(By.id("left-click"));
        String frontSideValueAgain = frontSideAgain.getAttribute("value");
        System.out.println("The value of the side in the front after a right click is: " + frontSideValueAgain);

        // Close the browser
        driver.close();
    }
}
