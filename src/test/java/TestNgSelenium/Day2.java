package TestNgSelenium;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day2 {

	@BeforeTest
	public void preexecuted()
	{
		System.out.println("I will be execute first");
		
	}
	@Test(groups={"Smoke"})
	public void secondtest()
	{
		System.out.println("Good");
	}
}
