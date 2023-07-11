package Framework.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;

	//WebElement userEmails = driver.findElement(By.id("userEmail"));
	// we are using constructor
		public LandingPage(WebDriver driver)
		{
			super(driver);
			//initialization
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		//pageFactory
		//WebElement userEmails = driver.findElement(By.id("userEmail")).sendKeys("shardha@gmail.com");
		@FindBy(id="userEmail")
		WebElement userEmail;
		
		//driver.findElement(By.id("userPassword")).sendKeys("Sk123456@");
		@FindBy(id="userPassword")
		WebElement passwordEle;
		
		// driver.findElement(By.id("login")).click();
		@FindBy(id="login")
		WebElement submit;
		
		@FindBy(css="[class*='flyInOut']")
		WebElement errorMessage;
		
		public productCatalogue LogInApplication(String email , String password)
		{
			userEmail.sendKeys(email);
			passwordEle.sendKeys(password);
			submit.click();
			productCatalogue productCatalogues = new productCatalogue(driver);
			return productCatalogues;
			
		}
		public String getErrorMessage()
		{
			waitForWebElementToAppear(errorMessage);
			return errorMessage.getText();
		}
		public void goTo()
		{
			driver.get("https://rahulshettyacademy.com/client");
		}
		}
		 
	

