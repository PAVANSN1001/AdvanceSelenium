package BasicSelenium;

import org.openqa.selenium.firefox.FirefoxDriver;

public class TitleUrl {

	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		//title
		String title = driver.getTitle();
		System.out.println("Title is = "+title);
		//Current URL
		String url = driver.getCurrentUrl();
		System.out.println("Current URL= "+url);
		driver.close();
	}

}
