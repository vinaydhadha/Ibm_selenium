import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class facebook {
    public static void main(String [] args){
            // Set the path to the ChromeDriver executable
            //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

            // Initialize ChromeDriver
            WebDriver driver = new ChromeDriver();

            // Navigate to the login page (replace with the actual URL)
            driver.get("https://www.facebook.com/");

            // Locate the username and password input fields and the login button
            WebElement usernameField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
            usernameField.sendKeys("vinay9686063963@gmail.com");
            WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
            passwordField.sendKeys("Vinay@123");
            WebElement loginButton = driver.findElement(By.id("loginButton"));

            // Enter credentials



            // Click the login button
            loginButton.click();

            // Perform any additional actions after login (if needed)

            // Close the browser
            driver.quit();
    }
}
