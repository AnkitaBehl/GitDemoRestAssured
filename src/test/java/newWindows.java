import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class newWindows {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver;
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
		 driver.manage().window().maximize();
		 
		 driver.get("https://rahulshettyacademy.com/angularpractice/");
		 
		 // open a new tab
		 driver.switchTo().newWindow(WindowType.TAB);
		 Set<String> windows =driver.getWindowHandles();
		  Iterator<String> it =windows.iterator();
		  String parentWindowId = it.next();
		  String childWindow =  it.next();
		  driver.switchTo().window(childWindow);
		  driver.get("https://rahulshettyacademy.com/");
		  String courseName =driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']"))
				  .get(1).getText();
		  driver.switchTo().window(parentWindowId);
		  WebElement name =driver.findElement(By.cssSelector("[name='name']"));
		  name.sendKeys(courseName);
		  
		  // Taking the screenshot
		  File file = name.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(file, new File("logo.png"));
		  
		  // Check the height and width
		   System.out.println(name.getRect().getDimension().getHeight());
		   System.out.println(name.getRect().getDimension().getWidth());
}

}
