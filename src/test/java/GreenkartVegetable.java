import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GreenkartVegetable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 int j=0;
		 
		String[] itemsNeeded = {"Brocolli", "Cucumber", "Tomato"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		//Thread.sleep(3000);
		List<WebElement> products =driver.findElements(By.cssSelector("h4,product-name"));
		
		for(int i=0;i<products.size();i++)
		{
			String[] name = products.get(i).getText().split("-");
			//Actual name = Bracolli - 1 Kg trip is used from clear the space , split is used for split the character 
			//name[0] = Brocolli
			String formattedName = name[0].trim();
			//here we are converting array to array list
			List itemsNeededList = Arrays.asList(itemsNeeded);
			
			if(itemsNeededList.contains(formattedName))
			{
				j++;
			
				driver.findElements(By.xpath("//div[@class = 'product-action']/button")).get(i).click();
				if(j==3)
					break;
			}
		}
		driver.findElement(By.cssSelector("img[alt ='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}

}
