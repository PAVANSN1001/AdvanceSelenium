package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateProduct {

	public static void main(String[] args) {
		EdgeDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//login
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Create Product
		driver.findElement(By.xpath("//span[text()='Add Product']")).click();
		WebElement target = driver.findElement(By.name("productId"));
		target.clear();
		target.sendKeys("Automated");
		//product quantity
		driver.findElement(By.name("productName")).sendKeys("LenovoLaptop");
		WebElement target1 = driver.findElement(By.name("quantity"));
		target1.clear();
		target1.sendKeys("10");
		WebElement target2 = driver.findElement(By.name("price"));
		target2.clear();
		target2.sendKeys("8");
		WebElement categorydropdown=driver.findElement(By.name("productCategory"));
		//Dropdown 1
		Select drop1=new Select(categorydropdown);
		drop1.selectByValue("Electricals");
		
		//DropDown 2
				WebElement vendordropdown=driver.findElement(By.name("vendorId"));
				Select drop2=new Select(vendordropdown);
				drop2.selectByValue("VID_007");
				driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
				driver.findElement(By.xpath("//button[@aria-label='close']")).click();
				
				//logout
				WebElement icon = driver.findElement(By.xpath("//div[@class='user-icon']"));
				Actions act=new Actions(driver);
				act.moveToElement(icon).perform();
				WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
				act.moveToElement(logout).click().perform();
				driver.quit();
				 
	}

}
