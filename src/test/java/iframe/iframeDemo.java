package iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iframeDemo {

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
	       

	        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");

	        driver.manage().window().maximize();

	        WebElement frame1 = driver.findElement(By.id("frameElement"));

	        driver.switchTo().frame(frame1);

	        driver.findElement(By.xpath("/html/body/button")).click();

	        driver.switchTo().parentFrame();

	        System.out.println(driver.getTitle());
	}

}
