package TestNgSelenium;


import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day3 {

	@Test
	public void Weblogincarloan()
	{
		//Selenium
		System.out.println(" Weblogincar");
	}
	@Test
	public void Mobilelogincarloan()
	{
		//Appium
		System.out.println("Mobilelogincar");
	}
	
	@Test(dataProvider ="getData")
	public void MobileSignincarloan(String username , String password)
	{
		//Appium
		System.out.println("Mobilesignincar");
		System.out.println(username);
		System.out.println(password);
	}
	@BeforeSuite
	public void Bfsuit()
	{
		System.out.println("I am no 1");
	}
	@Test(groups={"Smoke"})
	public void MobileSignoutcarloan()
	{
		//Appium
		System.out.println("Mobilesignoutcar");
	}
	@Test
	public void Apicarloan()
	{
		//Rest api automation
		System.out.println("Apilogincar");
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data= new Object[3][2];
		//1st set
		data[0][0]="firstsetuser";
		data[0][1]="firstpassword";
		
		//2nd set
		data[1][0]="secondsetuser";
		data[1][1]="secondpassword";
		
		//3rd set
		data[2][0]="thirdsetuser";
		data[2][1]="thirdpassword";
		return data;
		
			
				}
	
}
