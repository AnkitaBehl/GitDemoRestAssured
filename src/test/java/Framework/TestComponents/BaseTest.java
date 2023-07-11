package Framework.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Framework.pageobjectmodel.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingPage;
	
public WebDriver initializeDriver() throws IOException
{
	
	Properties prop = new Properties();
	FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"//src//main//java//Framework//resources//GlobalData.properties");
	prop.load(fis);
	String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
	//prop.getProperty("browser");
	
	if(browserName.contains("chrome"))
	{
	 ChromeOptions options = new ChromeOptions();
	 WebDriverManager.chromedriver().setup();
	 if(browserName.contains("headless")) {
	 options.addArguments("headless");
	 }
	 driver = new ChromeDriver(options);
	 driver.manage().window().setSize(new Dimension(1440,900));  // for full screen we can put as optional also
	
	}
	else if(browserName.equalsIgnoreCase("firefox"))
	{
		//System.setProperty("webdriver.gecko.driver", browserName)
		//firefox
	}
	else if(browserName.equalsIgnoreCase("Edge"))
	{
		//Edge
		System.setProperty("webdriver.edge.driver", "edge.exe");
		driver= new EdgeDriver();
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.manage().window().maximize();
	 return driver;
}
public List<HashMap<String, String>> getJasonDataToMap() throws IOException
{
	//read json to string 
	String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//Framework//data//PurchaseOrder.json"),
			StandardCharsets.UTF_8);
    // string to hashmap jackson databind
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
	});
   return data;
}
public String getScreenshot(String testCaseName,WebDriver driver) throws IOException 
{
	TakesScreenshot ts =(TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
	FileUtils.copyFile(source, file);
	return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	
}
   @BeforeMethod(alwaysRun=true)
  public LandingPage launchApplication() throws IOException
  {
	  driver = initializeDriver();
	  landingPage = new LandingPage(driver);
		 landingPage.goTo();
		 return landingPage;
  }
   @AfterMethod(alwaysRun=true)
   public void tearDown()
   {
	   driver.close();
   }
}
