package JavaPrograms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pyramaid1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WebDriver driver;
		// WebDriverManager.chromedriver().setup();
		// driver = new ChromeDriver();
		
		 //driver.manage().window().maximize();
		 int k=1;
		 for(int i=0;i<4;i++)
		 {
			 for(int j=0;j<4-i;j++)
			 {
				 System.out.print(k);
				 System.out.print("\t");
				 k++;
				 
			 }
			 System.out.println(" ");
		 }
		 
		
	}

}
