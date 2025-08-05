package CampaignTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import ObjectRepositories.CampaignPage;
import ObjectRepositories.HomePage;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertiesFileUtility;
import genericUtility.WebDriverUtility;


//@Listner(ListenerUtility.ListnerImlementation.class)

@Listeners(ListenerUtility.Listenerlmplementation.class)
public class CampaignTest extends BaseClass{
//private WebDriverUtility wdu;
	String CampaignName;
@Test(groups="regression")
public void toCreateCampaignWithMandatoryFieldsTest() throws EncryptedDocumentException, IOException {
ExcelFileUtility efu = new ExcelFileUtility();
JavaUtility ju = new JavaUtility();
//Read from excel
String campname = efu.toReadDataFromExcelFile("Campaign", 1, 2);
String target = efu.toReadDataFromExcelFile("Campaign", 1, 3);
int ran = ju.togetRandomNumber();
CampaignName = campname+ran;
// create campaign
HomePage hp=new HomePage(driver);
hp.getCreateCampbtn().click();
//Enter Mandatory field
CampaignPage cp = new CampaignPage(driver);
cp.getCampaignNameTF().sendKeys(CampaignName);
cp.getTargetSizeTF().sendKeys(target);
cp.getCreateCampaignSubmitBtn().click();
// validation
WebElement toastmsg = cp.getToastmsg();
WebDriverUtility wdu= new WebDriverUtility();
wdu.waitForVisibilityOfElement(driver, toastmsg);
String msg = toastmsg.getText();
Assert.assertTrue(msg.contains(CampaignName));
cp.getCloseMsg().click();
}
@Test(groups="smoke")
public void toCreateCampaignWithExpDateTest() throws EncryptedDocumentException, IOException, InterruptedException  {
PropertiesFileUtility pfu = new PropertiesFileUtility();
ExcelFileUtility efu = new ExcelFileUtility();
JavaUtility ju = new JavaUtility();
WebDriverUtility wdu = new WebDriverUtility();
String campname = efu.toReadDataFromExcelFile("Campaign", 1, 2);
String target = efu.toReadDataFromExcelFile("Campaign", 1, 3);
//String daterequired = ju.togetRequiredDate(30);
int ran = ju.togetRandomNumber();
CampaignName=campname + ran;
String expectedDate = ju.togetRequiredDate(30);
// create campaign
HomePage hp = new HomePage(driver);
hp.getCreateCampbtn().click();
CampaignPage cp = new CampaignPage(driver);
cp.getCampaignNameTF().sendKeys(campname);
cp.getTargetSizeTF().sendKeys(target);
Thread.sleep(2000);

wdu.passInput(driver,cp.getExpectedCloseDateTF(),ju.togetRequiredDate(30));
//WebElement expClosedate =cp.getExpectedCloseDateTF();
//wdu.passInput(driver, expClosedate, daterequired);
cp.getCreateCampaignSubmitBtn().click();
// validation
WebElement toastmsg = cp.getToastmsg();
wdu.waitForVisibilityOfElement(driver,cp.getToastmsg());
String msg = cp.getToastmsg().getText();
Assert.assertTrue(msg.contains(CampaignName));
cp.getCloseMsg().click();
}
@Test(groups="regression")
public void toCreateCampaignWithStatusTest() throws EncryptedDocumentException, IOException  {
ExcelFileUtility efu = new ExcelFileUtility();
//JavaUtility ju = new JavaUtility();
JavaUtility ju= new JavaUtility();
String campname = efu.toReadDataFromExcelFile("Campaign", 1, 2);
String target = efu.toReadDataFromExcelFile("Campaign", 1, 3);
String Status = efu.toReadDataFromExcelFile("Campaign", 1, 4);
int ran = ju.togetRandomNumber();
CampaignName=campname + ran;
// create campaign
HomePage hp = new HomePage(driver);
hp.getCreateCampbtn().click();
CampaignPage cp = new CampaignPage(driver);
cp.getCampaignNameTF().sendKeys(CampaignName);
cp.getCampaignStatusTF().sendKeys(Status);
cp.getTargetSizeTF().clear();
cp.getTargetSizeTF().sendKeys(target);
cp.getCreateCampaignSubmitBtn().click();
// validation
//WebElement toastmsg = cp.getToastmsg();
WebDriverUtility wdu=new WebDriverUtility();
wdu.waitForVisibilityOfElement(driver, cp.getToastmsg());
//WebDriverUtility wdu= new WebDriverUtility();
//wdu.waitForVisibilityOfElement(driver, toastmsg);
String msg = cp.getToastmsg().getText();
Assert.assertTrue(msg.contains(CampaignName));
cp.getCloseMsg().click();
}
}