package TestNgSelenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day4 {
@BeforeClass
public void Bfclass()
{
	System.out.println("i am the best no 1");
}
@AfterClass
public void Afclass()
{
	System.out.println("i am so inteligent");
}
@Parameters({"URL"})
	@Test
	public void Webloginloan( String urlloan)
	{
		//Selenium
		System.out.println(" Weblogin");
		System.out.println(urlloan);
	}
	@Test(groups={"Smoke"})
	public void Mobileloginload()
	{
		//Appium
		System.out.println("Mobilelogin");
	}
	@BeforeMethod
	public void Bfmetod()
	{
		System.out.println("i will be executed every day 3 class");
	}
	@AfterMethod
	public void Afmetod()
	{
		System.out.println("i will be executed every day 4 class");
	}
	@Test(groups={"Smoke"})
	public void LoginApiloan()
	{
		//Rest api automation
		System.out.println("Apilogin");
	}
}
