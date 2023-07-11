import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
		 driver.manage().window().maximize();
		 driver.get("https://www.path2usa.com/travel-companions");
		 Thread.sleep(1000);
		 JavascriptExecutor js = (JavascriptExecutor) driver;

	        //Launch the application		
	       // driver.get("https://www.browserstack.com/guide/selenium-scroll-tutorial");

	        //Locating element by link text and store in variable "Element"        		
	       // WebElement Element = driver.findElement(By.linkText("Try Selenium Testing For Free"));
	        WebElement ele=driver.findElement(By.xpath(".//*[@placeholder='Date of travel']"));
	        // Scrolling down the page till the element is found		
	        js.executeScript("arguments[0].scrollIntoView();", ele);
	        System.out.println("Testong");
	        Thread.sleep(2000);
	        Actions action = new Actions(driver).doubleClick(ele);
			action.build().perform();
		 //Actions a =new Actions(driver);
		//ele.click();
		// a.moveToElement(ele).build();
		 System.out.println("testing");
		driver.findElement(By.xpath(".//*[@class='flatpickr-next-month']")).click();
		
		
		 List<WebElement> dates = driver.findElements(By.xpath(".//*[@class='flatpickr-day ']"));
		 int lemngt=dates.size();
		 System.out.println(lemngt);
		int count = driver.findElements(By.xpath(".//*[@class='flatpickr-day ']")).size();
		for(int i=0;i<count;i++)
		{
			String text = driver.findElements(By.xpath(".//*[@class='flatpickr-day ']")).get(i).getText();
			if(text.equalsIgnoreCase("14"))
			{
				driver.findElements(By.xpath(".//*[@class='flatpickr-day ']")).get(i).click();
				break;
			}
		}
	}
}
