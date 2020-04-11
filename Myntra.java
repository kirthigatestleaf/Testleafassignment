package testleaf;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
				
		System.setProperty("webdriver.chrome.driver", "./chromedriver9.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		

		//login to the Website
		driver.get("https://www.myntra.com/");
		Thread.sleep(300);
		driver.manage().window().maximize();
		
		//Choose the Category as WOMEN
		
		Actions builder = new Actions(driver);
		
		WebElement mouse = driver.findElementByXPath("//div//a[text()='Women']");	
		builder.moveToElement(mouse).build().perform();
		
		//Select the Jackets & Coats Option		
		driver.findElementByXPath("//div//li//a[contains(text(),'Jackets & Coats')]").click();
		
		//Select the Total Item of Jacket and Coats		
		String number = driver.findElementByXPath("//div//h1[contains(text(),'Coats & Jackets For Women')]//following::span").getText();
		
		//The Process of getting only the Number		
	    String text = number.replaceAll("\\D", "");
	    System.out.println("The Total no of Item in String " +text);
	   
	    // Convert String to Int	 
	    int actualitemno = Integer.parseInt(text);	 
	    System.out.println("Actual item of Jacket and Coat " + actualitemno); 
	    
	    //Select only the no of Item in Jacket	 
	    String Jacket = driver.findElementByXPath("//div//span[contains(text(),'Categories')]/following::ul//label//input[@value = 'Jackets']//following-sibling::span").getText();
	    String text2 = Jacket.replaceAll("\\D", "");
	    System.out.println("no of Jacket Item in String  " + text2);	 
	    int jacketno = Integer.parseInt(text2);	 
	    System.out.println("No of Jacket Item in INT " + jacketno);
	    //Select only the no of Item in coats
	    String Coats = driver.findElementByXPath("//div//span[contains(text(),'Categories')]//following::ul//label//input[@value = 'Coats']//following-sibling::span").getText();
	    String text3 = Coats.replaceAll("\\D", "");
	    System.out.println("no of Coats Item in String " + text3);	 
	    int Coatsno = Integer.parseInt(text3);
	    System.out.println("Coat item in INT " + Coatsno);
	 // sum of  jacket items and coats items
	    int sum =  jacketno  + Coatsno;
	    System.out.println("Sum of both " +sum);
	 	 if (sum== actualitemno )
	 {
		 
		 System.out.println("Correctly matched");
	 }	 
	 else{
		 		 System.out.println("Not matched");
		 	 }
	 
	 driver.findElementByXPath("//div//span[contains(text(),'Categories')]/following::ul//label//input[@value = 'Coats']//following-sibling::div").click();
	 
	 driver.findElementByXPath("//div[@class='brand-more']").click();
	 
	 driver.findElementByXPath("//div//input[@placeholder='Search brand']").sendKeys("MANGO");	 
	 Thread.sleep(300);	 
	 WebElement Mango = driver.findElementByXPath("//div//ul[@class='FilterDirectory-list']//li//label//input[@value='MANGO']//following-sibling::div");
	 Mango.click();	 	 
	 //Close the small pop up Browser
	    driver.findElementByXPath("//div[@class='FilterDirectory-panel FilterDirectory-expanded']//div//ul[@class='FilterDirectory-indices']//following-sibling::span").click();
		Thread.sleep(300);		 	 
	 //Validate the Listed images are holding the Brand name of Mango		 
        List<WebElement> brand =driver.findElementsByXPath("//div//ul[@class='results-base']//h3[contains(text(),'MANGO')]");
         int noofbrands =  brand.size();       
         System.out.println("noofbrand of Mango "+ noofbrands);
              for(int i = 0 ; i < noofbrands; i++ )
       {
    	  String Match = brand.get(i).getText();
    	  if (!Match.contains("MANGO"))
    	  {
    		  System.out.println("The Fitered value is not showing the Brand of MAngo");
    		  System.out.println("Actual Value" + Match);    		  
    	  }    	   
       }
       
       System.out.println("The Fitered value are showing the Brand of MAngo");
       
       // Sort the record using the Better  discount option from the recommended menu 
              
   WebElement sort  = driver.findElementByXPath("//div[contains(text(),'Sort by ')]//span[contains(text(),'Recommended')]");
    builder.moveToElement(sort).build().perform();
    driver.findElementByXPath("//div//ul[@class='sort-list']//label//input[@value='discount']//parent::label").click();
 
    //After Sort Select  the First price from the list
	 
 List<WebElement> betterprice =driver.findElementsByXPath("//div//span[@class='product-discountedPrice']");
 String Firstlistedprice = betterprice.get(0).getText(); 
 String Price = Firstlistedprice.replaceAll("\\D", ""); 
 int Actualprice = Integer.parseInt(Price); 
 System.out.println("the First Listed Price " + Actualprice);
 //Move the Cursor to display the size of the  Jacket and Click the wishlist 
 builder.moveToElement(driver.findElementByXPath("//div//h4[contains(text(),'Women Double-Breasted Overcoat')]")).build().perform();
  driver.findElementByXPath("//div//span[contains(text(),'wishlist now')]").click();
 
 
	 }}
		 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
		
		
		
						
		
		
		

	


