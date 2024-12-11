package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShoppersStacks {
		
		public static String browser = "edge"; //External configuration - xls,csv
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
			
			driver.get("https://www.shoppersstack.com/user-signin");
			driver.manage().window().maximize();
			
//			driver.findElement(By.xpath("//button[@id='loginBtn']")).click();
			
			//locate user name--tag#id
			driver.findElement(By.cssSelector("input#Email")).sendKeys("abhaykr.cse@gmail.com");
			
			//locate password--tag[attribute=value]
			driver.findElement(By.cssSelector("input#Password")).sendKeys("Abhay@123");
			
//			//locate login button using tag value of class name
//			driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();
	
}
}