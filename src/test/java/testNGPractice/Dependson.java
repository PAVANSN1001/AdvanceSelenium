package testNGPractice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Dependson {
	@Test
	public void addCart() {
		Reporter.log("Added",true);
	}
	
	@Test(dependsOnMethods = "addCart")
	public void editCart() {
		Reporter.log("Edited",true);
	}
	
	@Test(dependsOnMethods ={"editCart","addCart"})
	public void deleteCart() {
		Reporter.log("Deleted",true);
	}
}
