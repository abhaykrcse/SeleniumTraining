package ui;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class datepicker {
    public static String browser = "chrome"; //External configuration - xls,csv
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
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

        	driver.get("https://www.singaporeair.com/en_UK/in/home?gad_source=1&gclid=CjwKCAjwxY-3BhAuEiwAu7Y6swWYM-1tLwc28M2bb57SESelvW2M8G45_iPc2rFAdtFUo3UKIQJtQRoCZYsQAvD_BwE&gclsrc=aw.ds#/book/bookflight");

        	driver.manage().window().maximize();
        	
        	driver.findElement(By.xpath("//input[@id='departDate1']")).click();
        	
        	String month="September 2024";
        	String exp_date="15";
        	
        	
        	
        	
        	while(true)
        	{
        	String text =driver.findElement(By.xpath("//input[@class='calendar-date-field ref--searchinput']")).getText();
        	
        	if (text.equals(month))
        	{
        		break;
        	}
        	else
        	{
        		driver.findElement(By.xpath("//a[@class='right']")).click();
        	}
        	}
        	List <WebElement> allDates = driver.findElements(By.xpath("//div[@class='calendar_month_left']//ul//li"));
        	
        	for(WebElement ele:allDates)
        	{
        		String date_text=ele.getText();
        		
        		String date[]=date_text.split("\n");
        		
        		if(date[1].equals(exp_date))
        		{
        			ele.click();
        			break;
        		}
        	}
    }

}
