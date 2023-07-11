import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		WebDriver driver;
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver(options);
		
		 driver.manage().window().maximize();
		 driver.get("https://expired.badssl.com/");
		 System.out.println(driver.getTitle());
	}

}
