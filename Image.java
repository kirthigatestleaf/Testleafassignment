package testleaf;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Image {
	
	
	public static void main(String[] args) throws InterruptedException 
	{
	
	System.setProperty("webdriver.chrome.driver", "./chromedriver9.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	driver.get("http://www.leafground.com/home.html");
	Thread.sleep(300);

	
	driver.findElementByXPath("//a//h5[text()='Image']/following-sibling::img").click();
	Thread.sleep(300);
	
	// No Of images 
	List<WebElement> image= driver.findElementsByTagName("img");
	
	  int size = image.size();
       System.out.println(image.size());
       
       
	//Using Action class Clicking the Button
WebElement images = driver.findElementByXPath("//div//label[text()='Click me using Keyboard or Mouse']/following-sibling::img");
Actions action = new Actions(driver);
action.moveToElement(images).click().perform();

Thread.sleep(300);

// Clicking onRadio button :

driver.findElementByXPath("//a//h5[text()='Radio Button']/following-sibling::img").click();

List<WebElement> radio= driver.findElementsByXPath("//input[@type='radio']");

int rsize = radio.size();
 System.out.println(radio.size());
 
 driver.navigate().back();
 Thread.sleep(300);
 driver.findElementByXPath("//a//h5[text()='Checkbox']/following-sibling::img").click();
 
 
 List<WebElement> check= driver.findElementsByXPath("//input[@type='checkbox']");

int checkb = check.size();
 System.out.println(check.size());
 
 for(int i=0;i<checkb;i++)
 {
	 
	check.get(i).click();
	 
	 
		 
 }
 
 


	}
}
