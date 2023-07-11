package ExtendReport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {
	ExtentReports extent;
@BeforeMethod
public void config()
{
	//Extent report , Extent spart reporter
	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Result");
	reporter.config().setDocumentTitle("Test Results");
	
	 extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "ExtendReport");
	
}
	
	@Test
	public void initialDemo()
	
	{
		ExtentTest test =extent.createTest("Initial Demo");
		WebDriver driver;
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 
		
		 driver.manage().window().maximize();
		 driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		driver.close();
		//test.fail("Result do not match");
		extent.flush();
	}
}
