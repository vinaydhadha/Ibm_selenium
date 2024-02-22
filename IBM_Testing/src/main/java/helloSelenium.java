
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
public class helloSelenium {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://v1.training-support.net");
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        //WebElement aboutUsButton = driver.findElement(By.id("aboutUs-link"));
        driver.findElement(By.id("about_link")).click();
       // aboutUsButton.click();
        String newPageTitle = driver.getTitle();
        System.out.println("New Page Title: " + newPageTitle);

        driver.close();
    }
}
