package BasicSelenium;

import org.openqa.selenium.chrome.ChromeDriver;

public class EqualIgnoreCase {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String str = driver.getTitle();
		if(str.equalsIgnoreCase("gOoGlE")){
		System.out.println("Google Webpage Displayed");
		}
		else
		{
		System.out.println("Google Webpage not displayed");
		}
		
	}

}
