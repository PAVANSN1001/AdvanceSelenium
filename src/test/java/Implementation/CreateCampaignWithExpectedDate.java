package Implementation;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

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

import ObjectRepositories.CampaignPage;
import ObjectRepositories.HomePage;
import ObjectRepositories.LoginPage;
import genericUtility.ExcelFileUtility;
import genericUtility.PropertiesFileUtility;
import genericUtility.WebDriverUtility;

public class CreateCampaignWithExpectedDate {

	public static void main(String[] args) throws IOException, InterruptedException {
		       //FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\Commondata.properties");
				//Properties prop=new Properties();
				//prop.load(fis);String BROWSER = prop.getProperty("Browser");
				//String URL = prop.getProperty("Url");
				//String USERNAME = prop.getProperty("Username");
				//String PASSWORD = prop.getProperty("Password");
				//Read data from excel
				//FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\TestScriptData.xlsx");
				//Workbook wb = WorkbookFactory.create(fis1);
				//Sheet sh = wb.getSheet("Campaign");
				//String campname = sh.getRow(1).getCell(2).getStringCellValue();
				//String size = sh.getRow(1).getCell(3).toString();
		PropertiesFileUtility pfu= new  PropertiesFileUtility();
		String USERNAME = pfu.togetDataFromPropertiesFile("Username");
		String BROWSER = pfu.togetDataFromPropertiesFile("Browser");
		String URL = pfu.togetDataFromPropertiesFile("Url");
		String PASSWORD = pfu.togetDataFromPropertiesFile("Password");
		
		ExcelFileUtility efu= new ExcelFileUtility();
		String campname = efu.toReadDataFromExcelFile("Campaign", 1, 2);
		String size = efu.toReadDataFromExcelFile("Campaign", 1, 3);
		
		
				//Random nbr generate
				//Random ran=new Random();
				//int randomcount = ran.nextInt(1000);
				
				
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
				//driver.manage().window().maximize();
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				//driver.get(URL);
		        //driver.findElement(By.id("username")).sendKeys(USERNAME);
				//driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
				//driver.findElement(By.xpath("//button[text()='Sign In']")).click();//create campaign
				//driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
				//driver.findElement(By.name("campaignName")).sendKeys(campname);
				WebDriverUtility wdu= new WebDriverUtility();
				wdu.waitForPageToLoad(driver);
				driver.get(URL);
				LoginPage lp= new LoginPage(driver);
				lp.getUN().sendKeys(USERNAME);
				lp.getPW().sendKeys(PASSWORD);
				lp.getLoginBtn().click();
				HomePage hp= new HomePage(driver);
				hp.getCreateCampbtn().click();
				//Get date after 30 days
				//Date date=new Date();
				//SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
				//sim.format(date);
				//Calendar cal = sim.getCalendar();
				//cal.add(Calendar.DAY_OF_MONTH,30);
				//String daterequired = sim.format(cal.getTime());
				CampaignPage cp=new CampaignPage(driver);
				cp.getExpectedCloseDateTF();
				cp.getTargetSizeTF();
				//WebElement target = driver.findElement(By.name("targetSize"));
				//target.clear();
				//target.sendKeys(size);
				Thread.sleep(2000);
				//WebElement expClosedate = driver.findElement(By.name("expectedCloseDate"));
				//Actions act=new Actions(driver);
				//act.click(expClosedate).sendKeys(daterequired).perform();
				cp.getExpectedCloseDateTF();
				hp.getCreateCampbtn().click();
				//driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
				
				
				
				
				//validation
				//WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
				//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
				//wait.until(ExpectedConditions.visibilityOf(toastmsg));
				//String msg = toastmsg.getText();
				cp.getCreateCampaignSubmitBtn().click();
				cp.getToastmsg();
				cp.getCloseMsg().click();
				//driver.findElement(By.xpath("//button[@aria-label='close']")).click();
				//logout
				//WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
				//act.moveToElement(icon).perform();
				//WebElement logoutbtn =driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
				//act.moveToElement(logoutbtn).click().perform();
				hp.getLogoutBtn().click();
				driver.quit();
	}

}
