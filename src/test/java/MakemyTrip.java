import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakemyTrip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		
		driver.get("https://www.makemytrip.com/flights/");
		//driver.findElement(By.xpath("//*[@id= 'whiteText makeFlex perfectCenter langSlct'")
	}

}
