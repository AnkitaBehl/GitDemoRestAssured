import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class GreenKartveg1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
		 driver.manage().window().maximize();
		 // here we used the locators
		 //above locator
		 driver.get("https://rahulshettyacademy.com/angularpractice/");
		 WebElement nameEditBox =  driver.findElement(By.cssSelector("[name='name']"));
		 System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		 
		 //below locator
		 WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		 driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
		 
		 //left locator
		 WebElement loveIceCream = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		 driver.findElement(with(By.tagName("input")).toLeftOf(loveIceCream)).click();
		 
		 // right locator
		 WebElement RadioButton = driver.findElement(By.id("inlineRadio1"));
		 System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(RadioButton)).getText());
		 
	}

}
