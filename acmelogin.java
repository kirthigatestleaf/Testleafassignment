package testleaf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class acmelogin {
	
	public static void main(String[] args) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "./chromedriver9.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://acme-test.uipath.com/account/login");
		WebElement UserName = driver.findElementById("email");
		UserName.sendKeys("kumar.testleaf@gmail.com");
		UserName.sendKeys(Keys.TAB);
		WebElement Password=driver.findElementById("password");
		Password.sendKeys("leaf@12");
		WebElement login=driver.findElementById("buttonLogin");
		login.click();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		WebElement Vendor = driver.findElementByXPath("//*[@id='dashmenu']//div[5]//button");
		Actions builder = new Actions(driver);
		builder.moveToElement(Vendor).perform();
		
		WebElement SVendor = driver.findElementByLinkText("Search for Vendor");
	SVendor.click();
	
	WebElement vname = driver.findElementById("vendorName");
	vname.sendKeys("Blue Lagoon");
	
	WebElement serach = driver.findElementById("buttonSearch");
	serach.click();
	
	WebElement country = driver.findElementByXPath("//html//body//div//div[2]//div//table//tbody//tr[2]//td[5]");
	
	System.out.println(country.getText());
	
	WebElement logout = driver.findElementByLinkText("Log Out");
	logout.click();
	
	driver.close();
	
	
	
	
	

		
		
		
		
			
		
		
	}
	

}
