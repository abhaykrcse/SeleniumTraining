package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class printAllelements {
    public static String browser = "edge"; //External configuration - xls,csv
    public static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

     	driver.get("https://www.sugarcrm.com/au/request-demo/"); 
    	driver.manage().window().maximize();

    	List<WebElement> allTags = driver.findElements(By.tagName("a"));
    	System.out.println("Total tags are: "+allTags.size());

    	for(int i=0;i<allTags.size();i++)

    	{

    	System.out.println("Links on page are "+allTags.get(i).getAttribute("href")); 
    	System.out.println("Links on page are "+allTags.get(i).getText());

}
}
}
