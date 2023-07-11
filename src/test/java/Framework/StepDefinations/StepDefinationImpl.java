package Framework.StepDefinations;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Framework.TestComponents.BaseTest;
import Framework.pageobjectmodel.CartPage;
import Framework.pageobjectmodel.CheckoutPage;
import Framework.pageobjectmodel.ConfirmationPage;
import Framework.pageobjectmodel.LandingPage;
import Framework.pageobjectmodel.productCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationImpl extends BaseTest  {
	
	public LandingPage landingPage;
	public productCatalogue productCatalogues;
	public ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException, InterruptedException
	{
		landingPage = launchApplication();
		//Thread.sleep(3000);
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.visibilityOfElementLocated());
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password)
	{
		productCatalogues = landingPage.LogInApplication(username,password);
	}
	
	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement> products = productCatalogues.getProductList();
		 productCatalogues.addProductToCart(productName);
	}
	
	@When("^Checkout (.+)and submit the order$")
	public void checkout_submit_order(String productName) throws InterruptedException
	{
	
         CartPage cartPage = productCatalogues.goToCartPage();
		 Boolean match = cartPage.VerifyProductDisplay(productName);
		 Assert.assertTrue(match);
	    cartPage.clickoncartbutton();
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();
	}
	
	@Then("{string} message is displayed on ConfirmationaPage")
	public void message_displayed_congirmationpage(String string)
	{
		String confirmMessage = confirmationPage.getConfirmationMessage();
		 Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		 driver.close();
	}
}
