package testleaf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Editlead {
		
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
				//Enter any First name
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("Babu");
		Thread.sleep(300);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(500);		
		
		//Click the first link
		driver.findElementByXPath("//table[@class='x-grid3-row-table']//tbody[1]//tr[1]//td[3]//div[1]//a[1]").click();
		Thread.sleep(300);
		//Get the Title
	     String title =	driver.findElementById("sectionHeaderTitle_leads").getText();
			System.out.println(title);
			driver.findElementByPartialLinkText("Edit").click();			
			// To update clear the existing field
			driver.findElementByXPath("(//input[@name='companyName'])[2]").clear();
			Thread.sleep(300);
						String update = "CSCupdatedtwo" ;
			driver.findElementByXPath("(//input[@name='companyName'])[2]").sendKeys(update);
			//after Update click Submit
						driver.findElementByClassName("smallSubmit").click();
						Thread.sleep(300);
			// confirm the update
			String text = driver.findElementById("viewLead_companyName_sp").getText();
				if (text.contains(update))
					{
				System.out.println("updated successfully");
					}		
				
				driver.close();

	}

}
