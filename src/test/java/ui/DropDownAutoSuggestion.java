package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownAutoSuggestion {
    public static String browser = "chrome"; //External configuration - xls,csv
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

        	driver.get("https://www.makemytrip.com/");

        	driver.manage().window().maximize();
        	
        	driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();

        	driver.findElement(By.xpath("//span[text()='From']")).click();

        	WebElement from = driver.findElement(By.xpath("//input[@placeholder='From']"));
        	Thread.sleep(2000);
        	from.sendKeys("Sydney");
        	Thread.sleep(2000);
        	from.sendKeys(Keys.ARROW_DOWN);
        	Thread.sleep(2000);
        	from.sendKeys (Keys.ENTER);
        	Thread.sleep(2000);
        // Close browser at the end
        // driver.quit();
    }

}
