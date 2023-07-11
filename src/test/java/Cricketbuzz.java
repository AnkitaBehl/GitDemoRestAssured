import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cricketbuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 
		 driver.get("https://www.cricbuzz.com/cricket-series/3961/icc-mens-t20-world-cup-2022/squads");
		System.out.println( driver.findElement(By.xpath("//*[@id='squadPlayers']/a[2]")).getText());
		System.out.println( driver.findElement(By.xpath("//*[@id='squadPlayers']/h3[2]")).getText());
		List<WebElement> elementName= driver.findElements(By.xpath(".//*[contains(text(),'Allrounder')]"));
		for(WebElement el:elementName)
		{
			System.out.println(el.getText());
		}
	}

}
