package ui;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import sun.net.www.protocol.http.HttpURLConnection;

public class BrokenLinks {

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
		
		
		//maximize browser
		driver.manage().window().maximize();
		
		//wait 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//open url
		driver.get("http://www.deadlinkcity.com/");
		
		//find hyperLinks
		List <WebElement> linkList = driver.findElements(By.tagName("a"));
		//System.out.println("Total links on webpage:" + linkElements.size());
		
		int resCode = 200;//2xx response code is valid link
		int brokenLinkCnt = 0;
		
		System.out.println("Total link on page:" +linkList.size());
		
		for(WebElement element:linkList)
		{
			String url = element.getAttribute("href");
			
			try {
			
				URL urlLink =new URL(url);
				
				HttpURLConnection huc=(HttpURLConnection)urlLink.openConnection();
				huc.setRequestMethod("HEAD");
				huc.connect();
				
				resCode=huc.getResponseCode();
			
			if(resCode>=400)
			{
				System.out.println(url + "broken link.");
						brokenLinkCnt ++;
						}
			}
			
			catch(MalformedURLException e)
			{
			}
			catch(Exception e)
			{
				
			}
			}
			System.out.print("Total broken links:" + brokenLinkCnt);
		}
		
		
		
}

