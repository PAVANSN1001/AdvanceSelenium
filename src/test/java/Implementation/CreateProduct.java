package Implementation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import ObjectRepositories.CampaignPage;
import ObjectRepositories.HomePage;
import ObjectRepositories.LoginPage;
import ObjectRepositories.ProductPage;
import genericUtility.ExcelFileUtility;
import genericUtility.PropertiesFileUtility;
import genericUtility.WebDriverUtility;

public class CreateProduct {

	private static WebDriver driver;

	public static void main(String[] args) {

			//EdgeDriver driver=new EdgeDriver();
			//driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PropertiesFileUtility pfu= new  PropertiesFileUtility();
		String USERNAME = pfu.togetDataFromPropertiesFile("Username");
		String BROWSER = pfu.togetDataFromPropertiesFile("Browser");
		String URL = pfu.togetDataFromPropertiesFile("Url");
		String PASSWORD = pfu.togetDataFromPropertiesFile("Password");
		
		ExcelFileUtility efu= new ExcelFileUtility();
		String prodname = efu.toReadDataFromExcelFile("Product", 1, 0);
		String quantity = efu.toReadDataFromExcelFile("Product", 1, 1);
		String price = efu.toReadDataFromExcelFile("Product", 1, 2);
			//login
		LoginPage lp=new LoginPage(null);
		lp.getUN().sendKeys(USERNAME);
		lp.getPW().sendKeys(PASSWORD);
		lp.getLoginBtn().click();
		
			//driver.get("http://49.249.28.218:8098/");
			//driver.findElement(By.id("username")).sendKeys("rmgyantra");
			//driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
			//driver.findElement(By.xpath("//button[text()='Sign In']")).click();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//Create Product
			HomePage hp= new HomePage(driver);
			hp.getProduct().click(); 
			ProductPage pp=new ProductPage(driver);
			pp.getAddProduct().click();
			//driver.findElement(By.xpath("//span[text()='Add Product']")).click();
			//WebElement target = driver.findElement(By.name("productId"));
			//target.clear();
			//target.sendKeys("Automated");
			//product quantity
			//driver.findElement(By.name("productName")).sendKeys("LenovoLaptop");
			pp.getProductName().sendKeys(prodname);
			pp.getProductId().sendKeys("uber");
			pp.getProductName().sendKeys("pavan");
			WebElement quantity1 = pp.getQuantity();
			quantity1.clear();
			quantity1.sendKeys(quantity);
			WebElement price1 = pp.getPrice();
			price1.clear();
			price1.sendKeys(price);
			//WebElement target1 = driver.findElement(By.name("quantity"));
			//target1.clear();
			//target1.sendKeys("10");
			//WebElement target2 = driver.findElement(By.name("price"));
			//target2.clear();
			//target2.sendKeys("8");
			//WebElement categorydropdown=driver.findElement(By.name("productCategory"));
			WebElement categorydropdown = pp.getProductCategory();
			//Dropdown 1
			WebDriverUtility wdu= new WebDriverUtility();
			wdu.select(categorydropdown,3);
			
			//Select drop1=new Select(categorydropdown);
			//drop1.selectByValue("Electricals");
			
			//DropDown 2
			WebElement vendordropdown = pp.getVendorId();
			wdu.select(vendordropdown, 1);
			pp.getAddProduct().click();
			CampaignPage cp=new CampaignPage(driver);
			cp.getCloseMsg().click();
					//WebElement vendordropdown=driver.findElement(By.name("vendorId"));
					//Select drop2=new Select(vendordropdown);
					//drop2.selectByValue("VID_007");
					//driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
					//driver.findElement(By.xpath("//button[@aria-label='close']")).click();
					
					//logout
						WebElement icon = hp.getUserIcon();
						wdu.mouseHoverOnWebElement(driver, icon);
						WebElement logout = hp.getLogoutBtn();
						wdu.clickOnWebElement(driver, logout);
					//WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
					//Actions act=new Actions(driver);
					//act.moveToElement(icon).perform();
					//WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
					//act.moveToElement(logout).click().perform();
					
					 
	}

}
