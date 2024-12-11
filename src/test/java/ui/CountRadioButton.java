package ui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountRadioButton {

	
public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium files\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		//maximize browser
		driver.manage().window().maximize();
		
		//open url https://udyamregistration.gov.in/Udyam_Login.aspx
		driver.get("https://site.pro/FAQ/");
		
		List <WebElement> radioButtonList = driver.findElements(By.xpath("//input[@type='radio']"));
		
		System.out.println("Total no. of radio button on web page:" + radioButtonList);
		driver.close();
		

		//
	
	}
	
}
