package testNGPractice;

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

import ObjectRepositories.HomePage;
import ObjectRepositories.LoginPage;
import genericUtility.PropertiesFileUtility;

public class Baseclass {
	public WebDriver driver = null;
	public PropertiesFileUtility plib = new PropertiesFileUtility();
	
	@BeforeSuite
	public void beforeSuite() {
	System.out.println("establish database connectivity");
	}
	@BeforeTest
	public void beforeTest() {
	System.out.println("preconditions");
	}
	@BeforeClass
	public void beforeClass() throws IOException {
	String BROWSER = plib.togetDataFromPropertiesFile("Browser");
	if (BROWSER.equals("Edge")) {
	driver = new EdgeDriver();
	} else if (BROWSER.equals("Chrome")) {
	driver = new ChromeDriver();
	} else if (BROWSER.equals("Firefox")) {
	driver = new FirefoxDriver();
	}
	System.out.println("launching browser");
	}
	@BeforeMethod
	public void beforeMethod() throws IOException{
	String URL = plib.togetDataFromPropertiesFile("Url");
	String USERNAME = plib.togetDataFromPropertiesFile("Username");
	String PASSWORD = plib.togetDataFromPropertiesFile("Password");
	driver.get(URL);
	LoginPage lp = new LoginPage(driver);
	lp.getUN().sendKeys(USERNAME);
	lp.getPW().sendKeys(PASSWORD);
	lp.getLoginBtn().click();
	System.out.println("Login done");
	}
	@AfterMethod
	public void afterMethod() {
	HomePage hp = new HomePage(driver);
	hp.getUserIcon().click();
	hp.getLogoutBtn().click();
	System.out.println("logout done");
	}
	@AfterClass
	public void afterClass() {
	driver.quit();System.out.println("closing browser");
	}
	@AfterTest
	public void afterTest() {
	System.out.println("post conditions");
	}
	@AfterSuite
	public void afterSuite() {
	System.out.println("closeDB connection");
	} 
	
}
