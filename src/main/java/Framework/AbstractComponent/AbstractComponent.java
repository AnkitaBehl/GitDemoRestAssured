package Framework.AbstractComponent;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.pageobjectmodel.CartPage;
import Framework.pageobjectmodel.OrderPage;

public class AbstractComponent {
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css="[routerlink*='cart']")
	WebElement cartHeader;
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;

	public void waitForElementToAppear(By findBy) {
	
	 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
}
	
	public void waitForWebElementToAppear(WebElement findBy) {
		
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public CartPage goToCartPage()
	{
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	public OrderPage goToOrdersPage()
	{
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}

	public void waitForElementtoDisappear(WebElement ele) throws InterruptedException 
	{
		Thread.sleep(1000);
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void clickoncartbutton()
	{
		cartHeader.click();
	}
	public void clickonorders()
	{
		orderHeader.click();
	}
}
