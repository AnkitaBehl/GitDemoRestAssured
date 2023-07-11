package Framework.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		String productName= "ADIDAS ORIGINAL";
		WebDriver driver;
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 
		
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("https://rahulshettyacademy.com/client");
		 driver.findElement(By.id("userEmail")).sendKeys("shardha@gmail.com");
		 driver.findElement(By.id("userPassword")).sendKeys("Sk123456@");
		 driver.findElement(By.id("login")).click();
		 
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		 
		 List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		 System.out.println("hello");
		 WebElement prod = products.stream().filter(product-> 
		 product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		 prod.findElement(By.xpath("(//button[contains(@class,'btn w-10 rounded')])[2]")).click();
		 
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		 //ng-animating
		 wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		 driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		 
		 List<WebElement> cartProducts = driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
		 Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		 Assert.assertTrue(match);
		 driver.findElement(By.xpath("//*[@class='totalRow']/button")).click();
		 
		 Actions a = new Actions(driver);
		 a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
		 
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		 driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	      WebElement table =driver.findElement(By.cssSelector(".action__submit"));
	  	js.executeScript("arguments[0].scrollIntoView();", table);
	  	Thread.sleep(3000);
	      
				driver.findElement(By.cssSelector(".action__submit")).click();
		 
		 String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		 Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		 driver.close();
		 
	}
	
	

}
