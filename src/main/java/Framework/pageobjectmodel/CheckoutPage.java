package Framework.pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Framework.AbstractComponent.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath=".//*[contains(text(),'Place Order')]")
	WebElement submit; 
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement selectCountry;
	
	By results = (By.cssSelector(".ta-results"));
	
	public void selectCountry(String countryName)
	{
		 Actions a = new Actions(driver);
		 a.sendKeys(country, countryName).build().perform();
		 
		 waitForElementToAppear(By.cssSelector(".ta-results"));
		 selectCountry.click();
	}
	
	public ConfirmationPage submitOrder() throws InterruptedException
	{
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	      WebElement table =driver.findElement(By.xpath(".//*[contains(text(),'Place Order')]"));
	  	js.executeScript("arguments[0].scrollIntoView();", table);
	  	Thread.sleep(1000);
		submit.click();
		 return new ConfirmationPage(driver);
	}
}
