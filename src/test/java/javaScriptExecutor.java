import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class javaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
		 driver.manage().window().maximize();
		 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("window.scrollBy(0,500)");
		 Thread.sleep(3000);
		 js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
		 
		 //or another method
		 
	/*WebElement table =driver.findElement(By.xpath(".//*[@class= 'tableFixHead']"));
	js.executeScript("arguments[0].scrollIntoView();", table);
	Thread.sleep(3000);*/
		 int sum =0;
		 
		List<WebElement> table =driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		for(int i=0; i<table.size();i++)
		{
			sum =sum +Integer.parseInt(table.get(i).getText());
		}
		System.out.println(sum);
		driver.findElement(By.cssSelector(".totalAmount")).getText();
		int total =  Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
	Assert.assertEquals(sum, total);
	}

}
