package Framework.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import Framework.TestComponents.BaseTest;
import Framework.pageobjectmodel.CartPage;
import Framework.pageobjectmodel.CheckoutPage;
import Framework.pageobjectmodel.ConfirmationPage;
import Framework.pageobjectmodel.LandingPage;
import Framework.pageobjectmodel.productCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationTest extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer = Framework.TestComponents.Retry.class)
	
	public void LoginErrorValidation() throws IOException, InterruptedException
	{

		String productName = "ADIDAS ORIGINAL";
	     landingPage.LogInApplication("shardha@gmail.com", "Sk1256@");
		 Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		 
	}
	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{

		String productName = "ADIDAS ORIGINAL";
		
		 productCatalogue productCatalogues = landingPage.LogInApplication("ranbeer@gmail.com", "Rk123456@");
		 List<WebElement> products = productCatalogues.getProductList();
		 productCatalogues.addProductToCart(productName);
		 CartPage cartPage = productCatalogues.goToCartPage();
		 
		 System.out.println(productName);
		 Boolean match = cartPage.VerifyProductDisplay(productName);
		 Assert.assertTrue(match);
		 System.out.println("emd");
	}

	


	}
	
	


