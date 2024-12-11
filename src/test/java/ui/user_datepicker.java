package ui;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class user_datepicker {

	  public static void main(String[] args) throws InterruptedException {

	        // Set up ChromeDriver
	        WebDriverManager.chromedriver().setup();
	        WebDriver driver = new ChromeDriver();

	        // Optional: Implicit wait
	        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

	        // Open the login page
	        driver.get("https://huhoka-dev-web.azurewebsites.net/login");

	        // Maximize the browser window
	        driver.manage().window().maximize();

	        // Enter username
	        driver.findElement(By.name("userName")).sendKeys("trainingqa@yopmail.com");

	        // Click SignIn button (Next)
	        driver.findElement(By.id("SignIn_Button_Next")).click();

	        // Enter password and click SignIn button
	        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Training1#");
	        driver.findElement(By.id("SignIn_Button_SignIn")).click();

	        // Click 'OK' button (after login success message)
	        driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();

	        // Click 'Apply Leave' button
	        driver.findElement(By.xpath("//button[@mattooltip='Apply leave']")).click();

	        // Interact with the dropdown (Select Leave Type)
	        driver.findElement(By.xpath("//span[text()='Select Leave Type']/parent::div/parent::div//div[2]")).click();

	        // Select the option (e.g., 'test Leave')
	        WebElement selectLeave = driver.findElement(By.xpath("//mat-option[@id='ApplyLeave_Button_SelectLeaveType_2']"));
	        selectLeave.click();
	        
			driver.findElement(By.xpath("//mat-datepicker-toggle[@id='ApplyLeave_Icon_DatePickerFromDate']//span[@class='mat-mdc-button-touch-target']")).click();
			
        	List<WebElement>al=driver.findElements(By.xpath("(//td[@role='gridcell'])"));

        	for(int i=0;i<al.size();i++)

        	{

        	String value=al.get(i).getText();
        	if(value.equalsIgnoreCase("20"))

        	{

        		al.get(i).click();
        		break;
        	}
        	}

        	
        	
    }

}
