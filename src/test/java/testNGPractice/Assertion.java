package testNGPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {
	
	@Test
	public void demo() {
		String expTitle="Facebook - log in or sign";
		WebDriver driver= new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		
		String actTitle=driver.getTitle();
		//Assert.assertEquals(expTitle, actTitle);
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(expTitle,actTitle);
		System.out.println("abc");
		System.out.println("zxcv");
		soft.assertAll();
		
	}
	

}
