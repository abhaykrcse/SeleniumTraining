package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class DropDownHandle {
    public static String browser = "edge"; //External configuration - xls,csv
    public static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        // Optional: Implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        driver.get("https://huhoka-dev-web.azurewebsites.net/login");
        driver.findElement(By.name("userName")).sendKeys("trainingqa@yopmail.com");
        
        // Click SignIn button
        driver.findElement(By.id("SignIn_Button_Next")).click();
        
        // Enter password and click SignIn button
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Training1#");
        driver.findElement(By.id("SignIn_Button_SignIn")).click();
        
        // Click 'OK' and 'Apply Leave' buttons
        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
        driver.findElement(By.xpath("//button[@mattooltip='Apply leave']")).click();
        
        // Interact with the non-standard dropdown (Leave Type)
        // Click on the dropdown to open the options
        WebElement dropdown = driver.findElement(By.xpath("//mat-label[.='Leave Type']"));
        dropdown.click();
        
        // Select the desired option from the dropdown (e.g., 'Sick Leave')
        WebElement option = driver.findElement(By.xpath("//span[contains(text(),'Sick Leave')]"));
        option.click();
        
        
//        WebElement dropdown = driver.findElement(By.xpath("//mat-label[.='Leave Type']"));
//        Select select = new Select(dropdown);
//        
//        select.selectVisibleText("S1 - 100 employees");
//        Thread.sleep(2000);
//        
//        select.selectByValue("level1");
//        Thread.sleep(2000);
//        
//        select.selectByIndex(0);
//        Thread.sleep(2000);
        
        // Close browser at the end
        // driver.quit();
    }
}
