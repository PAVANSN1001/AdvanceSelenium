package testNGPractice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Enabled {

	@Test
	public void a12(){
		Reporter.log("a12 executed",true);
	}
	@Test
	public void b12(){
		Reporter.log("b12 executed",true);
	}
	@Test
	public void b30(){
		Reporter.log("b30 executed",true);
	}
	@Test(enabled=false)
	public void a25(){
		Reporter.log("a25 executed",true);
	}
	@Test(invocationCount= 0)
	public void b10(){
		Reporter.log("b10 executed",true);
	}
	@Test
	public void a13(){
		Reporter.log("a13 executed",true);
	
}
}