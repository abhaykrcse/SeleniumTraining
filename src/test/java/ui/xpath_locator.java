package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class xpath_locator {
	
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

	//locate username using single attribute--//html tag>[@attribute_name='attribute_value'] / 
		//*[@attribute_name='attribute_value']
	driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
	
	//locate username using multiple attribute--//*[@attribute_name='attribute_value'][1]
	driver.findElement(By.xpath("//*[@id='password'][@name='password']")).sendKeys("secret_sauce");
	
	//locate username login button
	driver.findElement(By.xpath("//input[@id='login-button']")).click();
	
	//switch to product page
	String currentWindowHandle = driver.getWindowHandle();
	driver.switchTo().window(currentWindowHandle);
	
	//locate addcart using And
	driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack' and @name='add-to-cart-sauce-labs-backpack']")).click();
	//locate addcart using OR
	driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bolt-t-shirt' or @name='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
	//locate addcart using contains
	driver.findElement(By.xpath("//*[contains(@id,'add-to-cart-sauce-labs-onesie')]")).click();
	
	

	
	}
	
}