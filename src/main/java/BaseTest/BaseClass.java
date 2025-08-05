package BaseTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepositories.HomePage;
import ObjectRepositories.LoginPage;
import genericUtility.PropertiesFileUtility;

public class BaseClass {
		public WebDriver driver = null;
		public static WebDriver sdriver=null;//listner
		public PropertiesFileUtility pfu = new PropertiesFileUtility();
		@BeforeSuite(groups= {"smoke","regression"})
		public void beforeSuite() {
		System.out.println("establish database connectivity");
		}
		@BeforeTest(groups= {"smoke","regression"})
		public void beforeTest() {
		System.out.println("preconditions");
		}
		@Parameters("BROWSER")
		@BeforeClass(groups= {"smoke","regression"})
		public void beforeClass(String browser) throws IOException {
			
		String BROWSER=browser;	
		//String BROWSER = pfu.togetDataFromPropertiesFile("Browser");
		if (BROWSER.equals("Edge")) {
		driver = new EdgeDriver();
		} else if (BROWSER.equals("Chrome")) {
		driver = new ChromeDriver();
		} else if (BROWSER.equals("Firefox")) {
		driver = new FirefoxDriver();
		}
		sdriver=driver;
		System.out.println("launching browser");
		}
		@BeforeMethod(groups= {"smoke","regression"})
		public void beforeMethod() throws IOException {
		String URL = pfu.togetDataFromPropertiesFile("Url");
		String USERNAME = pfu.togetDataFromPropertiesFile("Username");
		String PASSWORD = pfu.togetDataFromPropertiesFile("Password");
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.getUN().sendKeys(USERNAME);
		lp.getPW().sendKeys(PASSWORD);
		lp.getLoginBtn().click();
		System.out.println("Login done");
		}
		@AfterMethod(groups= {"smoke","regression"})
		public void afterMethod() {
		HomePage hp = new HomePage(driver);
		hp.getUserIcon().click();
		hp.getLogoutBtn().click();
		System.out.println("logout done");
		}
		@AfterClass(groups= {"smoke","regression"})
		public void afterClass() {
		driver.quit();System.out.println("closing browser");
		}
		@AfterTest(groups= {"smoke","regression"})
		public void afterTest() {
		System.out.println("post conditions");
		}
		@AfterSuite(groups= {"smoke","regression"})
		public void afterSuite() {
		System.out.println("closeDB connection");
		}
}
