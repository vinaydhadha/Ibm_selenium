import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class googleSearch {
    public static void main(String[] args) {
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to Google search page
        driver.get("https://www.google.com/search?q=cheese&rlz=1C1GCEU_enIN1095IN1095&oq=cheese&gs_lcrp=EgZjaHJvbWUyDAgAEEUYORixAxiABDIQCAEQLhiDARixAxjJAxiABDIQCAIQLhjHARixAxjRAxiABDINCAMQABiDARixAxiABDIKCAQQABiSAxiABDIKCAUQABixAxiABDIKCAYQABixAxiABDIKCAcQABixAxiABDIKCAgQABixAxiABDIHCAkQABiABNIBCDY2NDhqMGo3qAIAsAIA&sourceid=chrome&ie=UTF-8");

        // Find the search box and input a search query
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]"));

        WebElement thirdRow = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[7]/div/div/div[1]/div/div/span/a/h3"));
        System.out.println(thirdRow);
        // Submit the search form
        searchBox.submit();
        // Close the browser
        //driver.quit();
    }


}

