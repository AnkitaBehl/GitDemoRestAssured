import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class actionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
		 driver.manage().window().maximize();
		 driver.get("https://www.amazon.com/");
		 Actions a = new Actions(driver);
		 a.moveToElement(driver.findElement(By.cssSelector("span[id='nav-link-accountList-nav-line-1']"))).build().perform();
		 a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
	

}
}
