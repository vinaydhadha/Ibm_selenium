import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class google {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to Google search page
        driver.get("https://www.google.com");

        // Find the search box and input a search query
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));
        searchBox.sendKeys("cheese");

        // Submit the search form
        searchBox.submit();

        // Wait for search results page to load
        try {
            Thread.sleep(3000); // Add a delay to wait for the search results to load (not recommended for real testing)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Find and print search results to the console
        System.out.println("Search Results:");
        WebElement resultsContainer = driver.findElement(By.xpath("//*[@id=\"result-stats\"]"));
        for (WebElement result : resultsContainer.findElements(By.xpath("//*[@id=\"result-stats\"]"))) {
            System.out.println(result.getText());
        }

        // Close the browser
        driver.quit();
    }
}
