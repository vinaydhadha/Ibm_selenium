import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Activity18 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        // Create a new instance of the Firefox driver
        WebDriver driver = new ChromeDriver();
        // Create the Wait object

        // Open the page
        driver.get("https://v1.training-support.net/selenium/selects");
        String pageTitle = driver.getTitle();
        System.out.println("Home page title: " + driver.getTitle());

// Perform actions on the Multi Select dropdown
        performMultiSelectActions(driver);
        driver.close();
    }
    private  static void performMultiSelectActions(WebDriver driver){
        WebElement multiSelectDropdown = driver.findElement(By.id("multi-select"));
        Select select = new Select(multiSelectDropdown);
        select.selectByVisibleText("Javascript");
        System.out.println("Selected option by visible text: JS");
        select.selectByIndex(3); // Index is 0-based
        select.selectByIndex(4);
        select.selectByIndex(5);
        System.out.println("Selected options by index: Options 4, 5, 6");

        select.selectByValue("node");
        System.out.println("Selected option by value: NodeJS");

        // Deselect the 5th option using index
        select.deselectByIndex(4); // Index is 0-based
        System.out.println("Deselected option by index: Option 5");
    }
}
