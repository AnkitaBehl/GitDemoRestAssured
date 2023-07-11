package Framework.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Framework.TestComponents.BaseTest;
import Framework.data.DataReader;
import Framework.pageobjectmodel.CartPage;
import Framework.pageobjectmodel.CheckoutPage;
import Framework.pageobjectmodel.ConfirmationPage;
import Framework.pageobjectmodel.LandingPage;
import Framework.pageobjectmodel.OrderPage;
import Framework.pageobjectmodel.productCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {
	String productName = "ADIDAS ORIGINAL";
	@Test(dataProvider="getData", groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{

		
		
		 productCatalogue productCatalogues = landingPage.LogInApplication(input.get("email"), input.get("password"));
		 List<WebElement> products = productCatalogues.getProductList();
		 System.out.println(input.get("product"));
		 productCatalogues.addProductToCart(input.get("product"));
		 CartPage cartPage = productCatalogues.goToCartPage();
		 
		 System.out.println(productName);
		 Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		 Assert.assertTrue(match);
		 cartPage.clickoncartbutton();
		// cartPage.clickonorders();
		 //cartPage.clickonorders();
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
	    String confirmMessage = confirmationPage.getConfirmationMessage();
		 Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
		 
		 System.out.println("emd");
	}
	@Test(dependsOnMethods = {"submitOrder"} )
	public void OrderHistoryTest()
	{
		//ADIDAS ORIGINAL
		productCatalogue productCatalogues = landingPage.LogInApplication("shardha@gmail.com", "Sk123456@");
		OrderPage ordersPage =productCatalogues.goToOrdersPage();
		ordersPage.clickonorders();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	}
	
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		DataReader dr=new DataReader();
		List<HashMap<String,String>> data = dr.getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//Framework//data//PurchaseOrder.json"); 
		return new Object[][] { {data.get(0)} , {data.get(1)} };
	}
	
	//HashMap<String,String> map= new HashMap<String,String>();
			//map.put("email","shardha@gmail.com");
			//map.put("password", "Sk123456@");
			//map.put("product", "ADIDAS ORIGINAL");
			
			//HashMap<String,String> map1= new HashMap<String,String>();
			//map1.put("email","alia@gmail.com");
			//map1.put("password", "Ak123456@");
			//map1.put("product", "IPHONE 13 PRO");
	


	}
	
	


