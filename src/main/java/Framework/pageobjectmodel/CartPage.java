package Framework.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.AbstractComponent.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;

	
	@FindBy(xpath = "//*[@class='totalRow']/button")
	WebElement checkoutEle;
	
	@FindBy(xpath = ".//*[@class='card-body']/h5")
	private List<WebElement> cartProducts;
	
		public CartPage(WebDriver driver)
		{
			super(driver);
			//initialization
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		
		public Boolean VerifyProductDisplay(String productName) 
		{
			Boolean match = cartProducts.stream().anyMatch(product-> product.getText().equalsIgnoreCase(productName.trim()));
			System.out.println(match);
			return match;
		}


		public CheckoutPage goToCheckout() {
			// TODO Auto-generated method stub
			checkoutEle.click();
			return new CheckoutPage(driver);
		}


	
		}
			
		
		

 

	

		
		
		 
	

