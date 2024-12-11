package ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class title {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//lunch google web page
				driver.navigate().to("https:\\www.google.com");
				
				//capture tittle of webpage and print
				String title = driver.getTitle();
				System.out.println("Page Title: " + title);
				
				//capture url of the webpage
				System.out.println("URL: " + driver.getCurrentUrl());
				
				//capture page source
				System.out.println("page source: " + driver.getPageSource());
				driver.close();
				//driver.quit();

	}

}
