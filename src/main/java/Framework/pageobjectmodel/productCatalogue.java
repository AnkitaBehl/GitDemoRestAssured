package Framework.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Framework.AbstractComponent.AbstractComponent;

public class productCatalogue extends AbstractComponent {
	WebDriver driver;

	//WebElement userEmails = driver.findElement(By.id("userEmail"));
	// we are using constructor
		public productCatalogue(WebDriver driver)
		{
			super(driver);
			//initialization
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		//pageFactory
		 //List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		@FindBy(css=".mb-3")
		List<WebElement> products;
		
		@FindBy(css=".ng-animating")
		WebElement spinner;
		
		By productsBy =(By.cssSelector(".mb-3"));
		By addToCart =By.xpath("(//button[contains(@class,'btn w-10 rounded')])[2]");
		By toastMessage = (By.cssSelector("#toast-container"));
		
		public List<WebElement> getProductList()
		{
			 waitForElementToAppear(productsBy);
			 return products;
		}
			
		
		

  public WebElement getProductByName(String productName)
  {
	  WebElement prod = getProductList().stream().filter(product-> 
		 product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	return prod;
	  
  }
  public void addProductToCart(String productName) throws InterruptedException
  {
	  WebElement prod = getProductByName(productName); 
	  prod.findElement(addToCart).click();
	  waitForElementToAppear(toastMessage);
	  waitForElementtoDisappear(spinner);
  }
}
	

		
		
		 
	

