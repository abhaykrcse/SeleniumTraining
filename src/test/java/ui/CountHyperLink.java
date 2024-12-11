package ui;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountHyperLink {
	
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
		
		driver.get("https://www.calculator.net/");

		driver.manage().window().maximize();
		
		List <WebElement> linkElements = driver.findElements(By.tagName("a"));
		System.out.println("Total links on webpage:" + linkElements.size());
		
		for(WebElement el:linkElements)
		{
			System.out.println(el.getText());
		}
		driver.close();
}
}
