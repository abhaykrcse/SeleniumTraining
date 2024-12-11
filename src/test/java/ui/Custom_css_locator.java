package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_css_locator {
	
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
		
		driver.get("https://www.saucedemo.com");
		
		//locate user name--tag#id
		driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
		
		//locate password--tag[attribute=value]
		driver.findElement(By.cssSelector("input[name=password]")).sendKeys("secret_sauce");
		
		//locate login button using tag value of class name
		driver.findElement(By.cssSelector("input.submit-button")).click();
		
		//switch to product page
		String currentWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(currentWindowHandle);
		
		//tag.valueClass[attribute=value]
		driver.findElement(By.cssSelector("button.btn[name=add-to-cart-sauce-labs-bike-light]")).click();
		
		//tag[attribute$=substring]
		driver.findElement(By.cssSelector("button[name$=onesie]")).click();
		
		//driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[2]/div[2]/button[1]")).click();
		
		
	}

}
