import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		
		driver.get("http://google.com");
		driver.navigate().to("https://rahulshettyacademy.com/");
		driver.navigate().back();
		driver.navigate().forward();
		
		
	}

}
