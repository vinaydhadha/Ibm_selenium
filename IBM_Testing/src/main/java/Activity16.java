import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;

public class Activity16 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new ChromeDriver();
        // Create the Wait object

        // Open the page
        driver.get("https://v1.training-support.net/selenium/selects");
        String pageTitle = driver.getTitle();
        System.out.println("Home page title: " + driver.getTitle());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Perform actions on the Single Select dropdown
        performSingleSelectActions(driver);
       driver.close();

    }
    private static void performSingleSelectActions(WebDriver driver) {
        // Locate the Single Select dropdown
        WebElement singleSelectDropdown = driver.findElement(By.id("single-select"));

        // Create a Select object
        Select select = new Select(singleSelectDropdown);

        // Select the second option using visible text
        select.selectByVisibleText("Option 2");
        System.out.println("Selected option by visible text: Option 2");

        // Select the third option using index
        select.selectByIndex(2); // Index is 0-based
        System.out.println("Selected option by index: Option 3");

        // Select the fourth option using value
        select.selectByValue("4");
        System.out.println("Selected option by value: Option 4");

        // Get all options and print them to the console
        List<WebElement> allOptions = select.getOptions();
        System.out.println("All options in the dropdown:");
        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }
    }
}
