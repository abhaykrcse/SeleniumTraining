package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class firsttest_title {

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
		//lunch google web page
		driver.navigate().to("https://www.selenium.dev/downloads/");
		
		//capture tittle of webpage and print
		String title = driver.getTitle();
		System.out.println("Page Title: " + title);
		
		//capture url of the webpage
		System.out.println("URL: " + driver.getCurrentUrl());
		
		//capture page source
		System.out.println("page source: " + driver.getPageSource());
		//driver.close();
		driver.quit();
	}

}
 