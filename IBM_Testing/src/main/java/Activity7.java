import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class Activity7 {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.get("https://v1.training-support.net/selenium/drag-drop");
        String pageTitle = driver.getTitle();
        System.out.println("page title is: " + pageTitle);

        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement dropzone1= driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(ball, dropzone1).build().perform();

        String dropzone1Text = dropzone1.getText();
        if (dropzone1Text.equals("Dropped!")){
            System.out.println("ball has enterd Dropzone 1");
        } else{
            System.out.println("Ball has not enterd Dropzone 1");
        }
        // Move the ball into "Dropzone 2"
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));
        actions.dragAndDrop(ball, dropzone2).build().perform();

        // Verify that the ball has entered Dropzone 2
        String dropzone2Text = dropzone2.getText();
        if (dropzone2Text.equals("Dropped!")) {
            System.out.println("Ball has entered Dropzone 2");
        } else {
            System.out.println("Ball has not entered Dropzone 2");
        }
        driver.close();


    }
}
