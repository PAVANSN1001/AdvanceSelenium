package BasicSelenium;

import org.openqa.selenium.firefox.FirefoxDriver;

public class get {

	public static void main(String[] args) {
		
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.close();
	}

}
