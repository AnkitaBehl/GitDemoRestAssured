package TestNgSelenium;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Day1 {

	@AfterTest
	public void lastececution()
	{
		System.out.println("I will Execute last");
	}
	@Test
	
	public void Demo()
	{
		System.out.println("Hello");
		System.out.println("Hello1");
		System.out.println("Hello2");
		System.out.println("Hello45");
		
	}
	@AfterSuite
	public void Afsuit()
	{
		System.out.println("I will be 1 last no ");
	}
  @Test
  public void SecondTest()
  {
	  System.out.println("Bye");
	  System.out.println("how are you");
	  System.out.println("love the data");
  }
}

