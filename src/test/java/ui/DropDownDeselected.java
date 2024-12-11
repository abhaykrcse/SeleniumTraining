package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDownDeselected {
    public static String browser = "edge"; //External configuration - xls,csv
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
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
        
        driver.get("https:www.seleniumeasy.com/teest/basic-select-dropdown-demo.html");
        driver.manage().window().maximize();
        
        WebElement ddown = driver.findElement(By.id("multi-select"));

        Select select = new Select(ddown);

        select.selectByValue("California");

        Thread.sleep(2000);

        select.selectByIndex(5);

        Thread.sleep(2000);

        List<WebElement> allItems = select.getAllSelectedOptions();

        System.out.println(allItems.size());

        select.deselectAll();

        Thread.sleep(2000);

        select.selectByValue("California");

        Thread.sleep(2000);

        select.selectByIndex(5);

        Thread.sleep(2000);

        select.deselectByIndex(5);

        Thread.sleep(2000);

        List<WebElement> allItems1 = select.getAllSelectedOptions(); 
        System.out.println(allItems1.size());

    

        
        // Close browser at the end
        // driver.quit();
    }
}
