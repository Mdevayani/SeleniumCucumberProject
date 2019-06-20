package testmeapp.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testmeapp.utility.Driver;



public class OnlineShoppingTest1 {
	WebDriver driver;
	
	// ExtentHtmlReporter htmlReporter;
	 
	@AfterTest
   public void endReportAfterTest() {
		
	}
   
   @AfterMethod
   public void getResultAfterMethod() {
		
	}
   
   @BeforeTest
   public void startReportBeforeTest() {
		driver=Driver.getDriver("chrome");
		   
		driver.get("http://10.232.237.143:443/TestMeApp/");
		
	}
                
   @Test(priority = 2)
   public void testLogin() {
   //	String title=driver.getTitle();
   	//Assert.assertTrue(title.contains("Login"));
	   driver.findElement(By.partialLinkText("SignIn")).click();

   	driver.findElement(By.id("userName")).sendKeys("Arjunaaaaa");
   	driver.findElement(By.id("password")).sendKeys("Arjun123");
   	driver.findElement(By.cssSelector("input[value='Login']")).click();
		
  	}
   
  @Test(priority = 3)
   public void testCart() throws InterruptedException {
   	
   	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
   	Actions action=new Actions(driver);
   	action.moveToElement(driver.findElement(By.partialLinkText("All Categories"))).perform();
   	action.click(driver.findElement(By.partialLinkText("Electronics"))).perform();
   	action.click(driver.findElement(By.partialLinkText("Travel Kit"))).perform();
   	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
   	action.click(driver.findElement(By.partialLinkText("Add to cart"))).perform();
   	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
   	action.moveToElement(driver.findElement(By.partialLinkText("Cart"))).click().perform();
   }
   	
  @Test(priority=4)
   public void testPayment() {
		driver.findElement(By.partialLinkText("Checkout")).click();
		driver.findElement(By.cssSelector("input[value='Proceed to Pay']")).click();

		driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label/i")).click();
		driver.findElement(By.id("btn")).click();
		driver.findElement(By.name("username")).sendKeys("Arjunaaaaa");
		driver.findElement(By.name("password")).sendKeys("Arjun123");
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		
		
		
	   
	  
		
  	}
 // @Test(priority = 1)
   public void testRegistration() {
   	
   	driver=Driver.getDriver("chrome");
   
driver.get("http://10.232.237.143:443/TestMeApp/");
driver.findElement(By.partialLinkText("SignUp")).click();
	
	driver.findElement(By.id("userName")).sendKeys("devayani123");
	driver.findElement(By.id("firstName")).sendKeys("devayani");
	driver.findElement(By.id("lastName")).sendKeys("mohanty");
	
	driver.findElement(By.id("password")).sendKeys("dev123");
	driver.findElement(By.id("pass_confirmation")).sendKeys("dev123");
	driver.findElement(By.cssSelector("input[value='Male']")).click();
	driver.findElement(By.id("emailAddress")).sendKeys("devm@email.com");
	driver.findElement(By.id("mobileNumber")).sendKeys("9876543210");
	driver.findElement(By.id("dob")).sendKeys("01/23/1994");
	driver.findElement(By.id("address")).sendKeys("Bangalore marathahalli");
	driver.findElement(By.id("securityQuestion")).sendKeys("What is your favour color?");
	driver.findElement(By.id("answer")).sendKeys("red");
	driver.findElement(By.cssSelector("input[value='Register']")).click();

   
   	
   	
		
  	}
   
   
   
}