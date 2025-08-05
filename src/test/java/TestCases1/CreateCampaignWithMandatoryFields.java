package TestCases1;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCampaignWithMandatoryFields {

	public static void main(String[] args) throws IOException {
		//Reading data from Properties file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String BROWSER = prop.getProperty("Browser");
		String URL = prop.getProperty("Url");
		String USERNAME = prop.getProperty("Username");
		String PASSWORD = prop.getProperty("Password");
		//Read data from excel
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Campaign");
		String campname = sh.getRow(1).getCell(2).toString();
		String size = sh.getRow(1).getCell(3).toString();
		Random ran=new Random();
		int randomcount = ran.nextInt(1000);
		WebDriver driver=null;
		if(BROWSER.equals("Edge"))
		{
		driver=new EdgeDriver();
		}
		else if(BROWSER.equals("Chrome"))
		{
		driver=new ChromeDriver();
		}
		else if(BROWSER.equals("Firefox"))
		{
		driver=new FirefoxDriver();
		}
		//login action
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();//create campaign
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(campname + randomcount);
		WebElement target = driver.findElement(By.name("targetSize"));
		target.clear();
		target.sendKeys(size);
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		//validation
		WebElement toastmsg =driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		String msg = toastmsg.getText();
		if(msg.contains(campname+randomcount))
		{
		System.out.println("campaign created");
		}
		else {
		System.out.println("campaign not created");
		}
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		//logout
		WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
		Actions act=new Actions(driver);
		act.moveToElement(icon).perform();
		WebElement logoutbtn =driver.findElement(By.xpath("//div[@class='dropdown-itemlogout']"));
		act.moveToElement(logoutbtn).click().perform();
		driver.quit();

	}

}
