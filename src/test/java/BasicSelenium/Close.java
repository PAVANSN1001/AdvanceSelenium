package BasicSelenium;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Close {

	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		FirefoxDriver driver1 = new FirefoxDriver();
		driver1.get("https://www.google.com/");
		driver1.close();
		driver.close();
	}

}
