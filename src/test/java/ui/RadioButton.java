package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {
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

        driver.get("https://www.sugarcrm.com/request-demo/"); 
        driver.manage().window().maximize();

        WebElement radio2 = driver.findElement(By.id("doio"));
        WebElement radio1 = driver.findElement(By.id("doio"));
        radio2.click();
        System.out.println(radio1.isSelected());
        System.out.println(radio2.isSelected());

        System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
        // Close browser at the end
        // driver.quit();
    }
}
