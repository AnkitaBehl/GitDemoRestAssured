import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestiveFlightDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class ='ui-menu-item'] a"));
		for(WebElement option : options)
		{
			if(option.getText().equalsIgnoreCase("India"))
				{
				option.click();
				}
			
		}
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());// first we fail
		driver.findElement(By.cssSelector("input[id*= 'SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*= 'SeniorCitizenDiscount']")).isSelected());//then we pass 
		//now we count the number of checkbox
		System.out.println(driver.findElements(By.cssSelector("input[type ='checkbox']")).size());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		//check the date is enable or dissable
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
				{
			System.out.println("its enable");
			Assert.assertTrue(true);
				}
		else
		{
			Assert.assertTrue(false);
		}
		
		
		
		
		
	}

}
