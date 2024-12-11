package ui;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class deal2Buy {

		public static void main(String[] args) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium files\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			
					//lunch google web page
					driver.navigate().to("https://lannister.deals2buy.in/");
					driver.manage().window().maximize();
					
					// login to the page
//					driver.findElement(By.cssSelector("div[class='bg-[#EF6056] px-4 py-3 text-white montserat-14 h-100']")).click();
//					
//					// click on login to google
//					driver.findElement(By.xpath("//span[text()='Login with Google']")).click();
//					
//					//enter email id
//					driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("abhaycoolkashyap@gmail.com");
//					driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
//					//enter password
//					driver.findElement(By.cssSelector("input[name='Passwd']")).sendKeys("Abhay#2000");
//					driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
//					
					   WebElement searchBox = driver.findElement(By.name("search_text")); 
			            searchBox.sendKeys("mobile");
			            searchBox.submit();
//			            
//			            String mainPage = driver.getWindowHandle();
//			            System.out.println("Mainpage" + mainPage);
//			      
//			            // click on mobile product
			            WebElement clickOnmobile = driver.findElement(By.xpath("//span[.='₹ 25,656']")); // Adjust selector as needed
			            clickOnmobile.click();
//					
			            WebElement shopNow = driver.findElement(By.xpath("//a[text()='shop now']")); // Adjust selector as needed
			            shopNow.click();
			            
//			            
//			            //  Add the product to the cart
//			            
//			            WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
//			            addToCartButton.click();
//
//			            // Navigate to the cart
//			            
//			            WebElement cartIcon = driver.findElement(By.id("cart-icon"));
//			            cartIcon.click();
//
//			            // Move product to wishlist
//			            
//			            WebElement moveToWishlistButton = driver.findElement(By.id("w-grkf6Yadut9R"));
//			            moveToWishlistButton.click();
//			            
//			            WebElement clickonaccount = driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));
//			            clickonaccount.click();
//
//			            // Verify the product is in the wishlist
//			           
//			            WebElement wishlistIcon = driver.findElement(By.id("wishlist-icon"));
//			            wishlistIcon.click();
//
//			            // Verify the product appears in the wishlist
//			           
//			            WebElement wishlistProduct = driver.findElement(By.cssSelector(".wishlist .product-item"));
//			            
//			            if (wishlistProduct != null) {
//			                System.out.println("Test passed: Product successfully moved to the wishlist");
//			            } else {
//			                System.out.println("Test failed: Product not found in the wishlist");
//			            }
			       
}
}
