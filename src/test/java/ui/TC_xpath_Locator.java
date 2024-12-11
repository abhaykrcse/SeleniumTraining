package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_xpath_Locator {

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
		
		//locate username by id
		driver.findElement(By.id("user-name")).sendKeys("standard_user");	
		
		//locate password by name
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		
		//loacte login button by class
		driver.findElement(By.className("btn_action")).click();
		
		//switch to product page
		String currWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(currWindowHandle);
		
		//locate Sauce Labs Bolt T-Shirt
		//driver.findElement(By.linkText("Sauce Labs Bike Light")).click(); //click operations
		
		//locate Bolt T-Shirt by partial linktext
		//driver.findElement(By.partialLinkText("Light")).click();
		
		List <WebElement> elementList=driver.findElements(By.partialLinkText("Sauce"));
		System.out.println("Element size:" + elementList.size());
}
}
