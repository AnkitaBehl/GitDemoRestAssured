import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testing2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//String name= "rahul";
		WebDriver driver;
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 String password = getpassword(driver);
		 
		 driver.get("https://rahulshettyacademy.com/locatorspractice/");
		 driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		 driver.findElement(By.name("inputPassword")).sendKeys(password);
		 driver.findElement(By.className("signInBtn")).click();
		 Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello rahul,");
		
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		driver.close();
		
		
	
	
	}
      public static String getpassword(WebDriver driver) throws InterruptedException
      {
    	  driver.get("https://rahulshettyacademy.com/locatorspractice/");
    	  driver.findElement(By.linkText("Forgot your password?")).click();
  		Thread.sleep(1000);
  		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText =driver.findElement(By.cssSelector("form p")).getText();
		//please use temporary password 'rahulshettyacademy' to Login.
		String[] passwordArray = passwordText.split("'");
		//String[]passwordArray2 = passwordArray[1].split["'"];
		//passwordArray2[0]
		String password = passwordArray[1].split("'")[0];
		return password;
		//0th index - please use temporary password
		//1st index - rahulshettyacademy to Login
		
		//0th index - rahulshettyacademy
		//1st index -to login
		
		
      }
}
