package ProductTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import ObjectRepositories.CampaignPage;
import ObjectRepositories.HomePage;
import ObjectRepositories.ProductPage;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;
import testNGPractice.Baseclass;

public class ProductTest extends BaseClass{

@Test
public void toCreateProductTest() throws EncryptedDocumentException, IOException, InterruptedException{
ExcelFileUtility efu = new ExcelFileUtility();
JavaUtility ju = new JavaUtility();
String prodname = efu.toReadDataFromExcelFile("Product", 1, 0);
String quantity1 = efu.toReadDataFromExcelFile("Product", 1, 1);
String price1 = efu.toReadDataFromExcelFile("Product", 1, 2);
// enter details
//Homepage hp = new Homepage(driver);
HomePage hp= new HomePage(driver);
hp.getProduct().click();
ProductPage pp = new ProductPage(driver);
pp.getAddProduct().click();
pp.getProductName().sendKeys(prodname + ju.togetRanddomNumber());
WebElement categorydropdown = pp.getProductCategory();
// Dropdown 1
WebDriverUtility wdu=new WebDriverUtility();
wdu.select(categorydropdown, 3);
WebElement quantity = pp.getQuantity();
quantity.clear();
quantity.sendKeys(quantity1);
WebElement price = pp.getPrice();
price.clear();
price.sendKeys(price1);
// DropDown 2
WebElement vendordropdown = pp.getVendorId();
wdu.select(vendordropdown, 1);
pp.getAddProduct().click();
Thread.sleep(2000);
CampaignPage cp = new CampaignPage(driver);
cp.getCloseMsg().click();

}
}