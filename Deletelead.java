package testleaf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Deletelead {
	
	public static void main(String[] args) throws InterruptedException
	{
	
	System.setProperty("webdriver.chrome.driver", "./chromedriver9.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	driver.get("http://leaftaps.com/opentaps/control/main");
	
	//login to the Website
	WebElement UserName = driver.findElementById("username");
	UserName.sendKeys("DemoSalesManager");
	WebElement Password=driver.findElementById("password");
	Password.sendKeys("crmsfa");
				//Click Submit
	driver.findElementByClassName("decorativeSubmit").click();
				// Click SRM/SFA Button
driver.findElementByLinkText("CRM/SFA").click();
Thread.sleep(300);		
//Click leads
driver.findElementByPartialLinkText("Leads").click();
Thread.sleep(300);		
//Find leads
driver.findElementByPartialLinkText("Find Leads").click();
Thread.sleep(300);

driver.findElementByXPath("//span[text()='Phone']").click();
driver.findElementByName("phoneNumber").sendKeys("109");
Thread.sleep(300);
driver.findElementByXPath("//button[text()='Find Leads']").click();
String empid = driver.findElementByXPath("//div//span[contains(text(),'Lead List')]//following::table[2]//tr//td//a").getText();
System.out.println(empid);
driver.findElementByXPath("//table[@class='x-grid3-row-table']//tbody[1]//tr[1]//td[3]//div[1]//a[1]").click();
Thread.sleep(300);

driver.findElementByLinkText("Delete").click();
Thread.sleep(300);
driver.findElementByPartialLinkText("Find Leads").click();
Thread.sleep(300);	
driver.findElementByXPath("//span[text()='Phone']").click();
driver.findElementByName("phoneNumber").sendKeys(empid);
Thread.sleep(300);
driver.findElementByXPath("//button[text()='Find Leads']").click();
Thread.sleep(500);	

String verify = driver.findElementByXPath("//div//span[contains(text(),'Lead List')]//following::table[3]//following::div").getText();



if (verify.equalsIgnoreCase("No records to display"))
{
	System.out.println("Deleted Successfully");
}


	}


}
