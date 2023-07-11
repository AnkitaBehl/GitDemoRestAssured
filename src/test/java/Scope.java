import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
		 driver.manage().window().maximize();
		 driver.get("https://qaclickacademy.com/practice.php");
		 
		 //Give me the count of all page links
		 System.out.println(driver.findElements(By.tagName("a")).size());
		 
		 // count of footer link
		 WebElement footerdriver =driver.findElement(By.id("gf-BIG"));
		 System.out.println(footerdriver.findElements(By.tagName("a")).size());
		 
		 //count of footer one section link
		 WebElement colomndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		 System.out.println(colomndriver.findElements(By.tagName("a")).size());
		 
		 //click on each link on the footer one section
		 for(int i=1; i<colomndriver.findElements(By.tagName("a")).size();i++)
		 {
			 String clickonlinktab =Keys.chord(Keys.CONTROL,Keys.ENTER);
			 colomndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinktab);
			 Thread.sleep(5000);
		 }
		 Set<String>abc =driver.getWindowHandles();
          Iterator<String> it = abc.iterator();
          while(it.hasNext())
          {
	        driver.switchTo().window(it.next());
	        System.out.println(driver.getTitle());
}
	}

}
