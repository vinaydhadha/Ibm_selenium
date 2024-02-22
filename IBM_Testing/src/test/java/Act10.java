import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static javax.management.openmbean.SimpleType.STRING;

public class Act10 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://v1.training-support.net/selenium/simple-form");
    }

    public static List<List<Object>> readExcel(String filePath) {
        List<List<Object>> data = new ArrayList<>();
        try {
            // Read the file as a stream
            FileInputStream file = new FileInputStream(filePath);

            // Create the workbook
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // Get first sheet from that workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through all the rows one by one
            for (Row row: sheet) {
                // Temp var
                List<Object> rowData = new ArrayList<>();
                // Iterate over all the cells one by one
                for(Cell cell: row) {
                    if(cell != null) {
                        switch (cell.getCellType()) {
                            case STRING -> rowData.add(cell.getStringCellValue());
                            case NUMERIC -> rowData.add(cell.getNumericCellValue());
                            case BOOLEAN -> rowData.add(cell.getBooleanCellValue());
                        }
                    }
                }
                data.add(rowData);
            }
            file.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @DataProvider(name = "Registration")
    public static Object[][] signUpInfo() {
        String filePath = "C:\\Users\\VinayKumarH\\IBM_Testing\\src\\test\\java\\act1.xlsx";
        List<List<Object>> data = readExcel(filePath);
        return new Object[][] {
                { data.get(1) },
                { data.get(2) },
                { data.get(3) },
        };
    }

    @Test(dataProvider = "Registration")
    public void registrationTest(List<Object> rows) {
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement phoneNumberField = driver.findElement(By.id("number"));

        // Clear the fields
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        phoneNumberField.clear();

        // Enter the data
        firstNameField.sendKeys(rows.get(1).toString());
        lastNameField.sendKeys(rows.get(2).toString());
        emailField.sendKeys(rows.get(3).toString());
        phoneNumberField.sendKeys(rows.get(4).toString());

        // Capture screenshot before submitting
        captureScreenshoot(rows.get(1).toString() + "_filled");

        driver.findElement(By.cssSelector("input.green")).click();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert message = driver.switchTo().alert();
        // Get the alert message
        System.out.println("Alert Message: " + message.getText());
        Reporter.log("Alert Message: " + message.getText());
        message.accept();

        captureScreenshoot(rows.get(1).toString() + "_submiited");//capture
        message.accept();

        captureScreenshoot(rows.get(1).toString() + "_popup_message");

        driver.navigate().refresh();
    }
    private void captureScreenshoot(String fileName){
        try{
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("LoggerScreenScreenshots/"+ fileName+".png");
            FileUtils.copyFile(sourceFile, destinationFile);
            System.out.println("Screenshot saved at: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    @AfterClass
    public void teardown() {
        driver.close();
    }
}





