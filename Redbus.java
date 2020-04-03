package testleaf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Redbus {
	
	public static void main(String[] args) throws InterruptedException
	{
		
	System.setProperty("webdriver.chrome.driver", "./chromedriver9.exe");
	ChromeDriver driver = new ChromeDriver();
	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	driver.get("https://www.redbus.in");
	Thread.sleep(500);
	WebElement start = driver.findElementById("src");
	start.sendKeys("Chennai");
	Thread.sleep(500);
	driver.findElementById("src").sendKeys(Keys.TAB);
	WebElement to=driver.findElementById("dest");
	to.sendKeys("Bangalore");
	Thread.sleep(500);
	driver.findElementById("dest").sendKeys(Keys.TAB);
	WebElement date = driver.findElementByXPath("//*[@id='rb-calendar_onward_cal']//table//tbody//tr[7]//td[4]");
	date.click();
	WebElement search = driver.findElementById("search_btn");
	search.click();
	WebElement click = driver.findElementByXPath("//*[@id='filter-block']//div//div[2]//ul[2]//li[4]//label[1]");
     click.click();
     WebElement sleeper = driver.findElementByXPath("//*[@id='filter-block']//div//div[2]//ul[3]//li[2]//label[2]");
     sleeper.click();
     WebElement seat = driver.findElementByXPath("//*[@id='root']//div/div[2]//div[2]//div[1]//div[7]//a//text()");
     seat.click();



    //driver.close();

}
}