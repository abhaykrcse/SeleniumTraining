package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class xpath_using_postiton {

	public static String browser = "chrome"; //External configuration - xls,csv
	public static WebDriver driver;

	public static void main(String[] args) {
		if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	
		}
		
		driver.get("https://only-testing-blog.blogspot.com/");
		
		//xpath using position()--//tag-name[@attribute-type='attribute-value'][position()=value]
		driver.findElement(By.xpath("//input[@type='text'][position()=2]")).sendKeys("Abhay");
		driver.findElement(By.xpath("//input[@name='sname'][last()]")).sendKeys("Abhay");
		
		driver.findElement(By.xpath("//input[@name='sname']")).sendKeys("Raja");
}
}
