package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Activity12 {
    public static void main( String[] args){
        WebDriver driver = new ChromeDriver();

        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        String pageTitle = driver.getTitle();
        System.out.println("page title is: " + pageTitle);
        // Find the text field
        WebElement textField = driver.findElement(By.cssSelector("#input-text"));
         boolean isTextFieldEnabledBefore = textField.isEnabled();
         System.out.println("Is text field Enabled Before: "+ isTextFieldEnabledBefore);
         WebElement msg = driver.findElement(By.cssSelector("#input-text-enable"));
         msg.click();
         boolean isTextFieldEnabledAfter = textField.isEnabled();
         System.out.println("is text field enabled After: " + isTextFieldEnabledAfter);
         System.out.println(msg.isEnabled());
         driver.quit();
    }
}
