package Framework.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.AbstractComponent.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;

	
	@FindBy(xpath = "//*[@class='totalRow']/button")
	WebElement checkoutEle;
	
	//@FindBy(xpath = ".//*[@class='card-body']/h5")
	//private List<WebElement> cartProducts;
	@FindBy(xpath = "//tbody/tr/td[2]")
	private List<WebElement> productNames;
	
		public OrderPage(WebDriver driver)
		{
			super(driver);
			//initialization
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		
		public Boolean VerifyOrderDisplay(String productName) 
		{
			Boolean match = productNames.stream().anyMatch(product-> product.getText().equalsIgnoreCase(productName));
			System.out.println(match);
			return match;
		}
			
		
		

  public CheckoutPage goToCheckout()
  {
	  checkoutEle.click();
	  return new CheckoutPage(driver);
	  
	  
  }
  
  
 
}
	

		
		
		 
	

